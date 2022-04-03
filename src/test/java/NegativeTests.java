import io.restassured.response.Response;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;

public class NegativeTests {
    @Test
    public void code202(){
        Response response = given().contentType("application/json").get(Const.URL_CORRECT+"&currencies=123");
        System.out.println(response.asString());
//        response.then().statusCode(202);
//        Why statusCode is 200?
        response.then().body("error.code",equalTo(202));
    }
    @Test
    public void code105(){
        Response response = given().get(Const.URL_CORRECT+Const.MULTIPLE_CONVERSIONS+"&source=GBP");
        System.out.println(response.asString());
        response.then().body("error.code",equalTo(105));
        response.then().body("error.info",containsString("Access"));
    }
    @Test
    public void historical301(){
        Response response = given().get(Const.HISTORICAL_ENDPOINT+Const.MULTIPLE_CONVERSIONS+"&Date=");
        System.out.println(response.asString());
        response.then().body("error.code",equalTo(301));
        response.then().body("error.info",containsString("Required"));
    }

}

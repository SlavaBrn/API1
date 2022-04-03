import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Security {
    @ParameterizedTest
    @ValueSource (strings = {Const.URL,Const.URL+"fsagha132435hdjdASDFFHH",Const.URL+"@#$%^&***((!@##$^^^",Const.URL+Const.TOKEN})
    public void noToken(String input){
        Response response = given().get(input);
        System.out.println(response.asString());
//        why status code 200?!
//        response.then().statusCode(101);
        response.then().body("error.code",equalTo(101));
//        Why last INPUT's' code is null? when it supposed to be 200?!
    }
    @Test
    public void success(){
        Response response = given().get(Const.URL+Const.TOKEN);
        System.out.println(response.asString());
        response.then().body("success",equalTo(true));

    }



}

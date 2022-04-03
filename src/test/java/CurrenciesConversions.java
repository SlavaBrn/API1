import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;

public class CurrenciesConversions {
//    @ParameterizedTest
//    @ValueSource(strings = {Const.USD_TO_EUR,Const.USD_TO_ILS,Const.USD_TO_RUB})
//    public void usdToIls(String input){
//        Response response = given().get(Const.URL_CORRECT+input);
//        System.out.println(response.asString());
//    }
//    tryed to use parametrized test but there is an error inflicted by website
    @Test
    public void conversionUsdToRub(){
        Response response = given().get(Const.URL_CORRECT+Const.USD_TO_RUB);
        System.out.println(response.asString());
        response.then().body("quotes.USDRUB",equalTo(74.17897f));
    }
    @Test
    public void conversionUsdToEur(){
        Response response = given().get(Const.URL_CORRECT+Const.USD_TO_EUR);
        System.out.println(response.asString());
        response.then().body("quotes.USDEUR",equalTo(0.885995f));
    }
    @Test
    public void conversionUsdToIls(){
        Response response = given().get(Const.URL_CORRECT+Const.USD_TO_ILS);
        System.out.println(response.asString());
        response.then().body("quotes.USDILS",equalTo(3.15785f));

    }

}

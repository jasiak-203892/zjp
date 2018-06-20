import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class AppTest {

    @Test
    public void basicPingTest() {

        given().when().get("http://localhost:8090/students").then().statusCode(200);
    }

    @Test
    public void bodyTest() {

        Response resp = RestAssured.get("http://localhost:8090/students");

        String data = resp.asString();

        System.out.println("Data is " + data);
    }
}

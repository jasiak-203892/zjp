import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class AppTest {

    @Test
    public void basicPingTest() {

        given().when().get("http://localhost:8090/students").then().statusCode(200);
    }


}

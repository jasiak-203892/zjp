import org.junit.Test;

public class AppTest {

    //TODO Konfiguracja z Travis CI
    @Test
    public void basicPingTest() {

        //given().when().get("http://localhost:8090/students").then().statusCode(200);
    }

    @Test
    public void bodyTest() {
        /*
        Response resp = RestAssured.get("http://localhost:8090/students");

        String data = resp.asString();

        System.out.println("Data is " + data); */
    }
}

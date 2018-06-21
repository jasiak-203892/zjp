import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import static io.restassured.RestAssured.given;

public class AppTest {

    //TODO Konfiguracja z Travis CI
    @Test
    public void basicPingTest() throws IOException {

       // ServerSocket s = new ServerSocket(0);
       // System.out.println("listening on port: " + s.getLocalPort());
        //given().when().get("http://localhost:"+s.getLocalPort()+"/students").then().statusCode(200);
    }

    @Test
    public void bodyTest() {
        /*
        Response resp = RestAssured.get("http://localhost:8090/students");

        String data = resp.asString();

        System.out.println("Data is " + data); */
    }
}

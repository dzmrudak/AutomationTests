package REST_API;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class restAssured {

    /*@Test
    public void simpleRestAssuredTest2_2() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data.id",equalTo(2))
                .body("data.first_name", equalTo("Janet"));
    }*/
}

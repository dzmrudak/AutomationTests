package tests.REST_API;

import com.google.gson.Gson;
import enums.ProjectType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class restAssured {

    @Test
    public void simpleRestAssuredTest() {
        RestAssured.baseURI = "https://aqa04onl04.testrail.io/";
        String expectedValue = "{" +
                "\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\"," +
                "\"first_name\":\"Janet\",\"last_name\":\"Weaver\"," +
                "\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"}," +
                "\"support\":{\"url\":\"https://reqres.in/#support-heading\"," +
                "\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";

        // Setup Request Object
        RequestSpecification request = RestAssured.given()
                .auth()
                .preemptive()
                .basic("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        // Setup Response Object
        String endpoint = "index.php?/api/v2/get_projects&is_completed=0";
        Response response = request.request(Method.GET, endpoint);

        // Get Response Status Code
        int statusCode = response.getStatusCode();

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        //Assert.assertEquals(responseBody, expectedValue);
    }

    @Test
    public void singleUserRestAssuredTest() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();
    }

    @Test
    public void singleUserRestAssuredTest2() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void serializationTest() {
        Gson gson = new Gson();
        Project project = Project.builder()
                .name("Name")
                .announcement("Announcement")
                .showAnnouncement(true)
                .type(1)
                .build();
        String result = gson.toJson(project);

        System.out.println(result);
    }

    @Test
    public void deSerializationTest() {
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"Name\",\"announcement\":\"Announcement\",\"isShowAnnouncement\":true,\"type\":\"SINGLE_WITH_BASELINE\"}";

        Project expectedProject = Project.builder()
                .name("Name")
                .announcement("Announcement")
                .showAnnouncement(true)
                .type(2)
                .build();

        Project project = gson.fromJson(jsonString, Project.class);

        System.out.println(project);

        Assert.assertTrue(expectedProject.equals(project));
    }

    @Test
    public void createUserRestAssuredTest() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log()
                .body();
    }

    @Test
    public void createUserRestAssuredTest2() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        int projectID = given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body()
                .extract().jsonPath().getInt("id");

        System.out.println(projectID);
    }

    @Test
    public void updateUserRestAssuredTest() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        String updatedAtDate = given()
                .body(bodyJson)
                .when()
                .put(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body()
                .extract().jsonPath().getString("updatedAt");

        Assert.assertNotNull(updatedAtDate);

    }

    @Test
    public void updateUserRestAssuredTest2() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        String updatedAtDate = given()
                .body(bodyJson)
                .when()
                .patch(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body()
                .extract().jsonPath().getString("updatedAt");

        Assert.assertNotNull(updatedAtDate);
    }

    @Test
    public void deleteUserRestAssuredTest() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .delete(endpoint)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .log()
                .body();

    }

    @Test
    public void registerUnsuccessfulRestAssuredTest() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/register";

        String bodyJson = "{\"email\": \"sydney@fife\"}";

        String errorText = given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log()
                .body()
                .extract().jsonPath().getString("error");

        Assert.assertEquals(errorText, "Missing email or username");
    }

    @Test
    public void resourceNotFoundRestAssuredTest() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/unknown/23";

        String emptyResponse = given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log()
                .body()
                .extract().jsonPath().getString("");

        Assert.assertEquals(emptyResponse, "[:]");
    }
}

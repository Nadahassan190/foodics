package StepDefinitions.Home;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class login {

    private String baseUrl = "https://pay2.foodics.dev/cp_internal";

    @Test
    public void testValidLogin() {
        given()
                .baseUri("https://pay2.foodics.dev/cp_internal")
                .basePath("login")
                .contentType(ContentType.JSON)
                .body("{ \"uername\": \"merchant@foodics.com\", \"password\": \"123456\" }")
                .post()
                .then()
                .statusCode(200);
    }

    @Test
    public void testInvalidLogin() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"invalid-username\",\"password\":\"invalid-password\"}")
                .post(baseUrl + "/login");

        Assert.assertEquals(response.statusCode(), 401);
        Assert.assertEquals(response.jsonPath().getString("error"), "Unauthorized");
    }

    @Test
    public void testMissingFields() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"\",\"password\":\"\"}")
                .post(baseUrl + "/login");

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.jsonPath().getString("error"), "Bad Request");
    }

}
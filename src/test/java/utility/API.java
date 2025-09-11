package utility;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.User;

public class API {

    private final String baseUrl;
    private final Faker faker;

    public API(String baseUrl) {
        this.baseUrl = baseUrl;
        this.faker = new Faker();
        RestAssured.baseURI = baseUrl;
    }

    public User createUser() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(6, 12);

        User user = new User(email, password, name, null);

        Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/register");
        response.then().statusCode(200);

        String token = response.jsonPath().getString("accessToken");
        user.setAccessToken(token);

        return user;
    }

    public void deleteUser(String token) {
        RestAssured
                .given()
                .header("Authorization", token)
                .delete("/api/auth/user")
                .then()
                .statusCode(202);
    }
}
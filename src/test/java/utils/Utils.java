package utils;

import com.testslotegrator.gson.*;

import static io.restassured.RestAssured.given;

public class Utils {

    public static Token token;
    public static User user;
    public static CredentialsResponse credentialsResponse;

    public static void getToken(String grantType, String scope) {
        GuestCredentials register = new GuestCredentials(grantType, scope);
        token = given()
                .body(register)
                .when()
                .post("/v2/oauth2/token")
                .then().log().all()
                .extract().as(Token.class);
    }

    public static void createUser(String surname, String name, String passwordChange, String passwordRepeat, String email, String currencyCode, String username){
        CreateUser createUser = new CreateUser(surname, name,  passwordChange,  passwordRepeat, email, currencyCode, username);
        user = given()
                .body(createUser)
                .when()
                .post("/v2/players")
                .then().log().all()
                .extract().as(User.class);

    }

    public static void sendAuthRequest(String password, String grantType, String username){
        CredentialsRequest credentialsRequest = new CredentialsRequest(password, grantType, username);
        credentialsResponse = given()
                .body(credentialsRequest)
                .when()
                .post("/v2/oauth2/token")
                .then().log().all()
                .extract().as(CredentialsResponse.class);
    }

    public static void getInfoAboutUser(int userId){
        user = given()
                .when()
                .get("/v2/players/" + userId)
                .then().log().all()
                .extract().as(User.class);
    }
}

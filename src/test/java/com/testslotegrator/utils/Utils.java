package com.testslotegrator.utils;

import com.testslotegrator.gson.*;
import com.testslotegrator.testsuites.UserTest;
import io.restassured.http.ContentType;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class Utils {

    public static Token token;
    public static UserResponse userResponse;
    public static CredentialsResponse credentialsResponse;

    private static final GuestCredentials GET_TOKEN_TO_GUEST_REQUEST = new GuestCredentials(UserTest.GRANT_TYPE_GUEST, UserTest.SCOPE);

    private static final String tokenEndpoint = "/v2/oauth2/token";
    private static final String playersEndpoint = "/v2/players";


    public static void getToken(String grantType, String scope, int statusCode) {
        GuestCredentials register = new GuestCredentials(grantType, scope);
        token = given()
                .header("Authorization", getAuthorization())
                .body(register)
                .when()
                .post(tokenEndpoint)
                .then().log().all().statusCode(statusCode)
                .extract().as(Token.class);
    }

    public static void createUser(String surname, String name, String passwordChange,
                                  String passwordRepeat, String email, String currencyCode, String username, int statusCode) {
        UserRequest userRequest = new UserRequest(surname, name, passwordChange, passwordRepeat, email, currencyCode, username);
        userResponse = given()
                .header("Authorization", getTokenForAuth(GET_TOKEN_TO_GUEST_REQUEST))
                .body(userRequest)
                .when()
                .post(playersEndpoint)
                .then().statusCode(statusCode).log().all()
                .extract().as(UserResponse.class);

    }


    public static void sendAuthRequest(String password, String grantType, String username, int statusCode) {
        CredentialsRequest credentialsRequest = new CredentialsRequest(password, grantType, username);
        credentialsResponse = given()
                .header("Authorization", getAuthorization())
                .body(credentialsRequest)
                .when()
                .post(tokenEndpoint)
                .then().statusCode(statusCode).log().all()
                .extract().as(CredentialsResponse.class);
    }

    public static void getInfoAboutUser(int userId, int statusCode) {
        userResponse = given()
                .header("Authorization", "Bearer " + credentialsResponse.getAccessToken())
                .log().all()
                .when()
                .log().all()
                .get(playersEndpoint + "/" + userId)
                .then().statusCode(statusCode).log().all()
                .extract().as(UserResponse.class);
    }


    private static String getAuthorization() {
        return "Basic " + Base64.getEncoder().encodeToString(UserTest.LOGIN.getBytes());
    }

    public static String getTokenForAuth(Object object) {
        Token token = given()
                .header("Authorization", getAuthorization())
                .contentType(ContentType.JSON)
                .body(object)
                .when()
                .post("/v2/oauth2/token")
                .then().log().all()
                .extract().as(Token.class);
        return "Bearer " + token.getAccessToken();
    }
}



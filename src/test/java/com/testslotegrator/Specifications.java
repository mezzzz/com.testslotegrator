package com.testslotegrator;

import com.testslotegrator.gson.Token;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class Specifications {


    public static String getToken(Object object, String login, String url) {
        Token token = given()
                .header("Authorization", getAuthorization(login))
                .contentType(ContentType.JSON)
                .body(object)
                .when()
                .post(url + "/v2/oauth2/token")
                .then().log().all()
                .extract().as(Token.class);
        return "Bearer " + token.getAccessToken();
    }


    public static RequestSpecification requestSpecification(String url, Object object, String login) {
        return new RequestSpecBuilder()
                .addHeader("Authorization", getToken(object, login, url))
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpecification(String url, String login) {
        return new RequestSpecBuilder()
                .addHeader("Authorization", getAuthorization(login))
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }


    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }


    public static void installSpec(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;

    }

    private static String getAuthorization(String login) {
        return "Basic " + Base64.getEncoder().encodeToString(login.getBytes());
    }
}

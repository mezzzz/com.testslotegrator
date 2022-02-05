package com.testslotegrator.testsuites;

import com.testslotegrator.Specifications;
import com.testslotegrator.asserts.UserAsserts;
import com.testslotegrator.gson.CredentialsRequest;
import com.testslotegrator.gson.GuestCredentials;
import org.apache.http.util.Asserts;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;
import static utils.Utils.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(PER_CLASS)
public class UserTest extends UserAsserts {

    private static final String LOGIN = "front_2d6b0a8391742f5d789d7d915755e09e:";
    private static final String URL = "http://test-api.d6.dev.devcaz.com";

    private static final int EXPIRES_IN = 86400;

    private static final String USERNAME = "janedoe050114";
    private static final String PASSWORD_CHANGE = "amFuZWRvZTEyMw==";
    private static final String PASSWORD_REPEAT = "amFuZWRvZTEyMw==";
    private static final String EMAIL = "janedoe050114@example.com";
    private static final String NAME = "Jane";
    private static final String SURNAME = "Doe";
    private static final String CURRENCY_CODE = "RUB";


    private static final int ID = 9588;
    private static final Integer COUNTRY_ID = null;
    private static final Integer TIMEZONE_ID = null;
    private static final String GENDER = null;
    private static final Long PHONE_NUMBER = null;
    private static final Date BIRTHDATE = null;
    private static final boolean BONUSES_ALLOWED = true;
    private static final boolean IS_VERIFIED = false;

    private static final String GRANT_TYPE = "password";
    private static final String GRANT_TYPE_GUEST = "client_credentials";
    private static final String SCOPE = "guest:default";

    private static final String TOKEN_TYPE = "Bearer";

    private static final GuestCredentials GET_TOKEN_TO_GUEST_REQUEST = new GuestCredentials(GRANT_TYPE_GUEST, SCOPE);

    private static final CredentialsRequest GET_TOKEN_TO_USER_REQUEST = new CredentialsRequest(PASSWORD_CHANGE, GRANT_TYPE, USERNAME);


    @org.junit.jupiter.api.Test
    @Order(0)
    void getTokenTest() {
        Specifications.installSpec(Specifications.requestSpecification(URL, LOGIN), Specifications.responseSpecification(200));
        getToken("client_credentials", "");
        checkToken("Bearer", 86400, 627);
    }


    @org.junit.jupiter.api.Test
    @Order(1)
    void createUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(URL, GET_TOKEN_TO_GUEST_REQUEST, LOGIN), Specifications.responseSpecification(201));
        createUser(SURNAME, NAME, PASSWORD_CHANGE, PASSWORD_REPEAT, EMAIL, CURRENCY_CODE, USERNAME);
        checkUser(ID, COUNTRY_ID, TIMEZONE_ID, USERNAME, EMAIL, NAME, SURNAME, GENDER, PHONE_NUMBER, BIRTHDATE, BONUSES_ALLOWED, IS_VERIFIED);
    }


    @org.junit.jupiter.api.Test
    @Order(2)
    void authUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(URL, LOGIN), Specifications.responseSpecification(200));
        sendAuthRequest(PASSWORD_CHANGE, GRANT_TYPE, USERNAME);
        checkIsAuth(TOKEN_TYPE, EXPIRES_IN, 627, 1222);
    }


    @org.junit.jupiter.api.Test
    @Order(3)
    public void getInfoAboutUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(URL, GET_TOKEN_TO_USER_REQUEST, LOGIN), Specifications.responseSpecification(200));
        getInfoAboutUser(ID);
        checkUser(ID, COUNTRY_ID, TIMEZONE_ID, USERNAME, EMAIL, NAME, SURNAME, GENDER, PHONE_NUMBER, BIRTHDATE, BONUSES_ALLOWED, IS_VERIFIED);
    }


    @org.junit.jupiter.api.Test
    @Order(4)
    public void getInfoAboutUser404() {
        Specifications.installSpec(Specifications.requestSpecification(URL, GET_TOKEN_TO_USER_REQUEST, LOGIN), Specifications.responseSpecification(404));
        getInfoAboutUser(0);
    }
    @AfterEach
    public void del (){

    }
}
package com.testslotegrator.testsuites;

import com.testslotegrator.Specifications;
import com.testslotegrator.UserAsserts;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static com.testslotegrator.utils.Utils.*;


public class UserTest extends UserAsserts {

    public static final String LOGIN = "front_2d6b0a8391742f5d789d7d915755e09e:";
    private static final String URL = "http://test-api.d6.dev.devcaz.com";

    private static final int EXPIRES_IN = 86400;
    public static final String USERNAME = "janedoe050134";
    public static final String PASSWORD_CHANGE = "amFuZWRvZTEyMw==";
    private static final String PASSWORD_REPEAT = "amFuZWRvZTEyMw==";
    private static final String EMAIL = "janedoe050134@example.com";
    private static final String NAME = "Jane";
    private static final String SURNAME = "Doe";
    private static final String CURRENCY_CODE = "RUB";


    private static final Integer COUNTRY_ID = null;
    private static final Integer TIMEZONE_ID = null;
    private static final String GENDER = null;
    private static final Long PHONE_NUMBER = null;
    private static final Date BIRTHDATE = null;
    private static final boolean BONUSES_ALLOWED = true;
    private static final boolean IS_VERIFIED = false;

    public static final String GRANT_TYPE = "password";
    public static final String GRANT_TYPE_GUEST = "client_credentials";
    public static final String SCOPE = "guest:default";

    private static final String TOKEN_TYPE = "Bearer";


    @BeforeClass
    public static void installSpecifications() {
        Specifications.installSpec(Specifications.requestSpecification(URL));
    }

    @Test
    public void testGetToken() {
        getToken(GRANT_TYPE_GUEST, SCOPE, 200);
        checkToken(TOKEN_TYPE, 86400, 627);
    }


    @Test
    public void createUserTest() {
        createUser(SURNAME, NAME, PASSWORD_CHANGE, PASSWORD_REPEAT, EMAIL, CURRENCY_CODE, USERNAME, 201);
        checkUser(COUNTRY_ID, TIMEZONE_ID, USERNAME, EMAIL, NAME, SURNAME, GENDER, PHONE_NUMBER, BIRTHDATE, BONUSES_ALLOWED, IS_VERIFIED);
    }


    @Test
    public void authUserTest() {
        sendAuthRequest(PASSWORD_CHANGE, GRANT_TYPE, USERNAME, 200);
        checkIsAuth(TOKEN_TYPE, EXPIRES_IN, 627, 1222);
    }


    @Test
    public void getInfoAboutUserTest() {
        createUser(SURNAME, NAME, PASSWORD_CHANGE, PASSWORD_REPEAT, EMAIL + "1", CURRENCY_CODE, USERNAME + "1", 201);
        sendAuthRequest(PASSWORD_CHANGE, GRANT_TYPE, USERNAME + "1", 200);
        getInfoAboutUser(userResponse.getId(), 200);
        checkUser(COUNTRY_ID, TIMEZONE_ID, USERNAME + "1", EMAIL + "1", NAME, SURNAME, GENDER, PHONE_NUMBER, BIRTHDATE, BONUSES_ALLOWED, IS_VERIFIED);
    }

    @Test
    public void getInfoAboutUser404() {
        getInfoAboutUser(0, 404);
    }

}
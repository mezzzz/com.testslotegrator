package com.testslotegrator.asserts;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static utils.Utils.*;

public class UserAsserts {


    public void checkToken(String tokenType, int expiresIn, int accessTokenLength) {
        assertEquals("tokenType", tokenType, token.getTokenType());
        assertEquals("expiresIn", expiresIn, token.getExpiresIn());
        assertEquals("accessTokenLength", accessTokenLength, token.getAccessToken().length());

    }

    public void checkUser(int id, Integer countryId, Integer timezoneId, String username, String email, String name, String surname,
                          String gender, Long phoneNumber, Date birthdate, boolean isBonusesAllowed, boolean isVerified) {
        assertEquals("id", id, user.getId());
        assertEquals("countryId", countryId, user.getCountryId());
        assertEquals("timezoneId", timezoneId, user.getTimezoneId());
        assertEquals("username", username, user.getUsername());
        assertEquals("email", email, user.getEmail());
        assertEquals("name", name, user.getName());
        assertEquals("surname", surname, user.getSurname());
        assertEquals("gender", gender, user.getGender());
        assertEquals("phoneNumber", phoneNumber, user.getPhoneNumber());
        assertEquals("birthdate", birthdate, user.getBirthdate());
        assertEquals("BonusesAllowed", isBonusesAllowed, user.isBonusesAllowed());
        assertEquals("isVerified", isVerified, user.isIsVerified());

    }

    public void checkIsAuth(String tokenType, int expiresIn, int accessTokenLength, int refreshTokenLength) {
        assertEquals("tokenType", tokenType, credentialsResponse.getTokenType());
        assertEquals("expiresIn", expiresIn, credentialsResponse.getExpiresIn());
        assertEquals("accessTokenLength", accessTokenLength, accessTokenLength);
        assertEquals("refreshTokenLength", refreshTokenLength, credentialsResponse.getRefreshToken().length());

    }

}

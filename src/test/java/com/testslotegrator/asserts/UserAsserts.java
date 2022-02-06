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
        assertEquals("id", id, userResponse.getId());
        assertEquals("countryId", countryId, userResponse.getCountryId());
        assertEquals("timezoneId", timezoneId, userResponse.getTimezoneId());
        assertEquals("username", username, userResponse.getUsername());
        assertEquals("email", email, userResponse.getEmail());
        assertEquals("name", name, userResponse.getName());
        assertEquals("surname", surname, userResponse.getSurname());
        assertEquals("gender", gender, userResponse.getGender());
        assertEquals("phoneNumber", phoneNumber, userResponse.getPhoneNumber());
        assertEquals("birthdate", birthdate, userResponse.getBirthdate());
        assertEquals("BonusesAllowed", isBonusesAllowed, userResponse.isBonusesAllowed());
        assertEquals("isVerified", isVerified, userResponse.isIsVerified());

    }

    public void checkIsAuth(String tokenType, int expiresIn, int accessTokenLength, int refreshTokenLength) {
        assertEquals("tokenType", tokenType, credentialsResponse.getTokenType());
        assertEquals("expiresIn", expiresIn, credentialsResponse.getExpiresIn());
        assertEquals("accessTokenLength", accessTokenLength, accessTokenLength);
        assertEquals("refreshTokenLength", refreshTokenLength, credentialsResponse.getRefreshToken().length());

    }
}

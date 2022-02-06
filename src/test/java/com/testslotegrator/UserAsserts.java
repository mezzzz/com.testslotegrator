package com.testslotegrator;

import com.testslotegrator.utils.Utils;
import junit.framework.TestCase;

import java.util.Date;

import static com.testslotegrator.utils.Utils.*;
import static junit.framework.TestCase.assertEquals;

public class UserAsserts {

    public void checkToken(String tokenType, int expiresIn, int accessTokenLength) {
        TestCase.assertEquals("tokenType", tokenType, token.getTokenType());
        TestCase.assertEquals("expiresIn", expiresIn, token.getExpiresIn());
        TestCase.assertEquals("accessTokenLength", accessTokenLength, token.getAccessToken().length());

    }

    public void checkUser(Integer countryId, Integer timezoneId, String username, String email, String name, String surname,
                          String gender, Long phoneNumber, Date birthdate, boolean isBonusesAllowed, boolean isVerified) {
        TestCase.assertTrue(userResponse.getId() > 0);
        TestCase.assertEquals("countryId", countryId, userResponse.getCountryId());
        TestCase.assertEquals("timezoneId", timezoneId, userResponse.getTimezoneId());
        TestCase.assertEquals("username", username, userResponse.getUsername());
        TestCase.assertEquals("email", email, userResponse.getEmail());
        TestCase.assertEquals("name", name, userResponse.getName());
        TestCase.assertEquals("surname", surname, userResponse.getSurname());
        TestCase.assertEquals("gender", gender, userResponse.getGender());
        TestCase.assertEquals("phoneNumber", phoneNumber, userResponse.getPhoneNumber());
        TestCase.assertEquals("birthdate", birthdate, userResponse.getBirthdate());
        TestCase.assertEquals("BonusesAllowed", isBonusesAllowed, userResponse.isBonusesAllowed());
        TestCase.assertEquals("isVerified", isVerified, userResponse.isIsVerified());

    }

    public void checkIsAuth(String tokenType, int expiresIn, int accessTokenLength, int refreshTokenLength) {
        assertEquals("tokenType", tokenType, credentialsResponse.getTokenType());
        assertEquals("expiresIn", expiresIn, credentialsResponse.getExpiresIn());
        assertEquals("accessTokenLength", accessTokenLength, accessTokenLength);
        assertEquals("refreshTokenLength", refreshTokenLength, credentialsResponse.getRefreshToken().length());

    }
}

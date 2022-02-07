package com.testslotegrator;

import com.testslotegrator.utils.Utils;
import junit.framework.TestCase;

import java.util.Date;

import static com.testslotegrator.utils.Utils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserAsserts {

    public void checkToken(String tokenType, int expiresIn, int accessTokenLength) {
        assertEquals("tokenType", tokenType, token.getTokenType());
        assertEquals("expiresIn", expiresIn, token.getExpiresIn());
        assertEquals("accessTokenLength", accessTokenLength, token.getAccessToken().length());

    }

    public void checkUser(Integer countryId, Integer timezoneId, String username, String email, String name, String surname,
                          String gender, Long phoneNumber, Date birthdate, boolean isBonusesAllowed, boolean isVerified) {
        assertTrue(userResponse.getId() > 0);
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

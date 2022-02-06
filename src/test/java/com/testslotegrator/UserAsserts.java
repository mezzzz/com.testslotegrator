package com.testslotegrator;

import com.testslotegrator.utils.Utils;
import junit.framework.TestCase;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class UserAsserts {

    public void checkToken(String tokenType, int expiresIn, int accessTokenLength) {
        TestCase.assertEquals("tokenType", tokenType, Utils.token.getTokenType());
        TestCase.assertEquals("expiresIn", expiresIn, Utils.token.getExpiresIn());
        TestCase.assertEquals("accessTokenLength", accessTokenLength, Utils.token.getAccessToken().length());

    }

    public void checkUser(int id, Integer countryId, Integer timezoneId, String username, String email, String name, String surname,
                          String gender, Long phoneNumber, Date birthdate, boolean isBonusesAllowed, boolean isVerified) {
        TestCase.assertEquals("id", id, Utils.userResponse.getId());
        TestCase.assertEquals("countryId", countryId, Utils.userResponse.getCountryId());
        TestCase.assertEquals("timezoneId", timezoneId, Utils.userResponse.getTimezoneId());
        TestCase.assertEquals("username", username, Utils.userResponse.getUsername());
        TestCase.assertEquals("email", email, Utils.userResponse.getEmail());
        TestCase.assertEquals("name", name, Utils.userResponse.getName());
        TestCase.assertEquals("surname", surname, Utils.userResponse.getSurname());
        TestCase.assertEquals("gender", gender, Utils.userResponse.getGender());
        TestCase.assertEquals("phoneNumber", phoneNumber, Utils.userResponse.getPhoneNumber());
        TestCase.assertEquals("birthdate", birthdate, Utils.userResponse.getBirthdate());
        TestCase.assertEquals("BonusesAllowed", isBonusesAllowed, Utils.userResponse.isBonusesAllowed());
        TestCase.assertEquals("isVerified", isVerified, Utils.userResponse.isIsVerified());

    }

    public void checkIsAuth(String tokenType, int expiresIn, int accessTokenLength, int refreshTokenLength) {
        TestCase.assertEquals("tokenType", tokenType, Utils.credentialsResponse.getTokenType());
        TestCase.assertEquals("expiresIn", expiresIn, Utils.credentialsResponse.getExpiresIn());
        assertEquals("accessTokenLength", accessTokenLength, accessTokenLength);
        TestCase.assertEquals("refreshTokenLength", refreshTokenLength, Utils.credentialsResponse.getRefreshToken().length());

    }
}

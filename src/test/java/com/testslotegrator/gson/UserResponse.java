package com.testslotegrator.gson;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserResponse {

    @SerializedName("bonuses_allowed")
    private boolean bonusesAllowed;

    @SerializedName("birthdate")
    private Date birthdate;

    @SerializedName("gender")
    private String gender;

    @SerializedName("surname")
    private String surname;

    @SerializedName("timezone_id")
    private Integer timezoneId;

    @SerializedName("name")
    private String name;

    @SerializedName("phone_number")
    private Long phoneNumber;

    @SerializedName("id")
    private int id;

    @SerializedName("is_verified")
    private boolean isVerified;

    @SerializedName("country_id")
    private Integer countryId;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    public boolean isBonusesAllowed() {
        return bonusesAllowed;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getTimezoneId() {
        return timezoneId;
    }

    public String getName() {
        return name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
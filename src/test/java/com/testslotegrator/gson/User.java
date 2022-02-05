package com.testslotegrator.gson;

import com.google.gson.annotations.SerializedName;

public class User{

    @SerializedName("bonuses_allowed")
    private boolean bonusesAllowed;

    @SerializedName("birthdate")
    private String birthdate;

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

    public boolean isBonusesAllowed(){
        return bonusesAllowed;
    }

    public Object getBirthdate(){
        return birthdate;
    }

    public Object getGender(){
        return gender;
    }

    public String getSurname(){
        return surname;
    }

    public Object getTimezoneId(){
        return timezoneId;
    }

    public String getName(){
        return name;
    }

    public Object getPhoneNumber(){
        return phoneNumber;
    }

    public int getId(){
        return id;
    }

    public boolean isIsVerified(){
        return isVerified;
    }

    public Object getCountryId(){
        return countryId;
    }

    public String getEmail(){
        return email;
    }

    public String getUsername(){
        return username;
    }
}
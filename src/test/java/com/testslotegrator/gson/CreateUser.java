package com.testslotegrator.gson;

import com.google.gson.annotations.SerializedName;

public class CreateUser{
    public CreateUser(String surname, String name, String passwordChange, String passwordRepeat, String email, String currencyCode, String username) {
        this.surname = surname;
        this.name = name;
        this.passwordChange = passwordChange;
        this.passwordRepeat = passwordRepeat;
        this.email = email;
        this.currencyCode = currencyCode;
        this.username = username;
    }

    @SerializedName("surname")
    private String surname;

    @SerializedName("name")
    private String name;

    @SerializedName("password_change")
    private String passwordChange;

    @SerializedName("password_repeat")
    private String passwordRepeat;

    @SerializedName("email")
    private String email;

    @SerializedName("currency_code")
    private String currencyCode;

    @SerializedName("username")
    private String username;

    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public String getPasswordChange(){
        return passwordChange;
    }

    public String getPasswordRepeat(){
        return passwordRepeat;
    }

    public String getEmail(){
        return email;
    }

    public String getCurrencyCode(){
        return currencyCode;
    }

    public String getUsername(){
        return username;
    }
}
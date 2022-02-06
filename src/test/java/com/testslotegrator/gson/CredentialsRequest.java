package com.testslotegrator.gson;

import com.google.gson.annotations.SerializedName;

public class CredentialsRequest {
    public CredentialsRequest(String password, String grantType, String username) {
        this.password = password;
        this.grantType = grantType;
        this.username = username;
    }

    @SerializedName("password")
    private String password;

    @SerializedName("grant_type")
    private String grantType;

    @SerializedName("username")
    private String username;

    public String getPassword() {
        return password;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getUsername() {
        return username;
    }
}
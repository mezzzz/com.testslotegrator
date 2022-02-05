package com.testslotegrator.gson;

import com.google.gson.annotations.SerializedName;

public class CredentialsResponse{
    public CredentialsResponse(String accessToken, String refreshToken, String tokenType, int expiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
    }

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    public String getAccessToken(){
        return accessToken;
    }

    public String getRefreshToken(){
        return refreshToken;
    }

    public String getTokenType(){
        return tokenType;
    }

    public int getExpiresIn(){
        return expiresIn;
    }
}
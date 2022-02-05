package com.testslotegrator.gson;

import com.google.gson.annotations.SerializedName;

public class GuestCredentials {

    @SerializedName("grant_type")
    private String grantType;

    @SerializedName("scope")
    private String scope;

    public String getGrantType(){
        return grantType;
    }

    public String getScope(){
        return scope;
    }

    public GuestCredentials(String grantType, String scope){
        this.grantType = grantType;
        this.scope = scope;
    }
}
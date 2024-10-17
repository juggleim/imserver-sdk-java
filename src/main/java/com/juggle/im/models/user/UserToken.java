package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

public class UserToken {
    @SerializedName("token")
	String token;
	@SerializedName("user_id")
	String userId;

	public UserToken(String userId, String token){
        this.userId = userId;
        this.token = token;
    }

    public UserToken setUserId(String userId){
        this.userId = userId;
        return this;
    }

    public String getUserId(){
        return this.userId;
    }

    public UserToken setToken(String token){
        this.token = token;
        return this;
    }

    public String getToken(){
        return this.token;
    }
}

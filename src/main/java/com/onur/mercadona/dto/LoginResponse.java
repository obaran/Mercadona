package com.onur.mercadona.dto;

public class LoginResponse {

    private String Token;

    public LoginResponse(String tontoken) {
        Token = tontoken;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}

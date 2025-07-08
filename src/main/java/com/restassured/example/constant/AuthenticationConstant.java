package com.restassured.example.constant;

import java.net.URISyntaxException;

import static com.restassured.example.util.FileReader.getEnvironmentConfig;

public class AuthenticationConstant {
    public static final String USERNAME;

    static {
        try {
            USERNAME = getEnvironmentConfig("username");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String PASSWORD;

    static {
        try {
            PASSWORD = getEnvironmentConfig("password");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

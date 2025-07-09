package com.restassured.example.constant;

import java.net.URISyntaxException;
import java.util.UUID;

import static com.restassured.example.util.FileReader.getEnvironmentConfig;

public class AuthenticationConstant {
    public static final int ID;

    static {
        try {
            ID = Integer.parseInt(getEnvironmentConfig("id")) + Math.abs(UUID.randomUUID().toString().hashCode());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String USERNAME;

    static {
        try {
            USERNAME = getEnvironmentConfig("email") + Math.abs(UUID.randomUUID().toString().hashCode()) + "gmail.com";
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

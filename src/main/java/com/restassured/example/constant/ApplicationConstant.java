package com.restassured.example.constant;

import java.net.URISyntaxException;

import static com.restassured.example.util.FileReader.getEnvironmentConfig;

public class ApplicationConstant {
    // Base URLs
    public static final String RESTFUL_BOOKER_BASE_URL;

    static {
        try {
            RESTFUL_BOOKER_BASE_URL = getEnvironmentConfig("book_base_url");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    // API Endpoints
    public static final String SIGNUP_SERVICE_ENDPOINT = "/signup";
    public static final String HEALTH_SERVICE_ENDPOINT = "/health";
    public static final String AUTH_SERVICE_ENDPOINT = "/login";
//    public static final String BOOKING_SERVICE_ENDPOINT = "/booking";
    public static final String BOOKS_SERVICE_ENDPOINT = "/books/";

    // Headers
    public static final String AUTH_HEADER_NAME = "Cookie";
    public static final String AUTH_TOKEN_PREFIX = "token=";
}

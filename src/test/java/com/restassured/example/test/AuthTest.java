package com.restassured.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.example.Category;
import com.restassured.example.model.AuthenticationRequest;
import com.restassured.example.util.RestClient;
import org.testng.annotations.Test;

import static com.restassured.example.HttpMethod.POST;
import static com.restassured.example.constant.ApplicationConstant.*;
import static com.restassured.example.constant.AuthenticationConstant.*;
import static com.restassured.example.test.constant.TestCategory.AUTHENTICATION;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthTest extends BaseTest {
    @Category(AUTHENTICATION)
    @Test(description = "Verify that a user can get the access token")
    public void testAuthentication() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setId(ID);
        authenticationRequest.setEmail(USERNAME);
        authenticationRequest.setPassword(PASSWORD);

        ObjectMapper objectMapper = new ObjectMapper();
        String authRequestJson;
        try {
            authRequestJson = objectMapper.writeValueAsString(authenticationRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        new RestClient(RESTFUL_BOOKER_BASE_URL, SIGNUP_SERVICE_ENDPOINT, authRequestJson)
                .sendRequest(POST)
                .statusCode(SC_OK)
                .body("message", equalTo("User created successfully"));

        new RestClient(RESTFUL_BOOKER_BASE_URL, AUTH_SERVICE_ENDPOINT, authRequestJson)
                .sendRequest(POST)
                .statusCode(SC_OK)
                .body("access_token", notNullValue());
    }
}

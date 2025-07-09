package com.restassured.example.service.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.example.model.AuthenticationRequest;
import com.restassured.example.util.RestClient;

import java.util.Collections;
import java.util.Map;

import static com.restassured.example.HttpMethod.POST;
import static com.restassured.example.constant.ApplicationConstant.*;
import static com.restassured.example.constant.AuthenticationConstant.*;

public class AuthenticationService {
    public static Map<String, String> getAuthenticationHeaders() {
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

        String token = new RestClient(RESTFUL_BOOKER_BASE_URL, AUTH_SERVICE_ENDPOINT, authRequestJson)
                .sendRequest(POST)
                .extract()
                .body()
                .jsonPath()
                .get("access_token")
                .toString();

        return Collections.singletonMap("Authorization", "Bearer " + token);
    }
}

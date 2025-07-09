package com.restassured.example.service.app;

import com.restassured.example.util.RestClient;

import java.util.Collections;

import static com.restassured.example.HttpMethod.GET;
import static com.restassured.example.constant.ApplicationConstant.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

public class BooksService {
    public static String getBookingIdFromBookingDb() {
        return new RestClient(RESTFUL_BOOKER_BASE_URL, BOOKS_SERVICE_ENDPOINT,
                Collections.emptyMap(), true, Collections.emptyMap(), EMPTY)
                .sendRequest(GET)
                .statusCode(SC_OK)
                .extract()
                .body()
                .jsonPath()
                .get("[0].id")
                .toString();
    }
}

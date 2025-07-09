package com.restassured.example.test;

import com.restassured.example.Category;
import com.restassured.example.util.RestClient;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.restassured.example.HttpMethod.GET;
import static com.restassured.example.constant.ApplicationConstant.*;
import static com.restassured.example.test.constant.TestCategory.BOOKS;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertTrue;

public class GetAllBooksTest extends BaseTest {
    @Category(BOOKS)
    @Test(description = "Verify that all book details are received")
    public void testGetAllBooks() {
        ValidatableResponse response = new RestClient(RESTFUL_BOOKER_BASE_URL, BOOKS_SERVICE_ENDPOINT,
                Collections.emptyMap(), true, Collections.emptyMap(), EMPTY)
                .sendRequest(GET)
                .statusCode(SC_OK);

        assertTrue(response.extract().body().jsonPath().getList("$").size() >= 1);
    }
}

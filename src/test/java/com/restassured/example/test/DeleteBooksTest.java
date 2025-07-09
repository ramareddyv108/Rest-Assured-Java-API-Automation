package com.restassured.example.test;

import com.restassured.example.Category;
import com.restassured.example.util.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.restassured.example.HttpMethod.DELETE;
import static com.restassured.example.constant.ApplicationConstant.*;
import static com.restassured.example.service.app.BooksService.getBookingIdFromBookingDb;
import static com.restassured.example.test.constant.TestCategory.BOOKS;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.http.HttpStatus.*;

public class DeleteBooksTest extends BaseTest {
    private String deleteBookingEndpoint;

    @BeforeMethod
    public void setDeleteBookingEndpoint() {
        deleteBookingEndpoint = BOOKS_SERVICE_ENDPOINT
//                .concat("/")
                .concat(getBookingIdFromBookingDb());
    }

    @Category(BOOKS)
    @Test(description = "Verify that a book can be deleted")
    public void testBooksDeletion() {
        new RestClient(RESTFUL_BOOKER_BASE_URL, deleteBookingEndpoint, Collections.emptyMap(),
                true, Collections.emptyMap(), EMPTY)
                .sendRequest(DELETE)
                .statusCode(SC_OK);
    }

    @Category(BOOKS)
    @Test(description = "Verify that a book cannot be deleted without the authentication")
    public void testBooksDeletionWithoutAuthentication() {
        new RestClient(RESTFUL_BOOKER_BASE_URL, deleteBookingEndpoint, Collections.emptyMap(),
                false, Collections.emptyMap(), EMPTY)
                .sendRequest(DELETE)
                .statusCode(SC_FORBIDDEN);
    }
}

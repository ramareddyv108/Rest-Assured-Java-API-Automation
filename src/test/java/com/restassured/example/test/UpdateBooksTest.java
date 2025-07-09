package com.restassured.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.example.Category;
import com.restassured.example.model.Books;
import com.restassured.example.util.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.restassured.example.HttpMethod.PUT;
import static com.restassured.example.constant.ApplicationConstant.*;
import static com.restassured.example.service.app.BooksService.getBookingIdFromBookingDb;
import static com.restassured.example.test.constant.TestCategory.BOOKS;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateBooksTest extends BaseTest {
    private final Books books = new Books();
//    private final BookingRequest bookingRequest = new BookingRequest();
    private String updateBookingEndpoint;
    private String updateBookingRequestJson;

    @BeforeMethod
    public void setUpdateBookingPayload() {
        updateBookingEndpoint = BOOKS_SERVICE_ENDPOINT
//                .concat("/")
                .concat(getBookingIdFromBookingDb());

        books.setPublished_year("2024-04-01");
        books.setId("3");
        books.setName(getMockService().names().first().get());
        books.setAuthor(getMockService().names().last().get());
        books.setBook_summary("fiction");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            updateBookingRequestJson = objectMapper.writeValueAsString(books);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Category(BOOKS)
    @Test(description = "Verify that a book details can be updated")
    public void testUpdateBooking() {
        new RestClient(RESTFUL_BOOKER_BASE_URL, updateBookingEndpoint, Collections.emptyMap(),
                true, Collections.emptyMap(), updateBookingRequestJson)
                .sendRequest(PUT)
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .body("name", equalTo(books.getName()))
                .body("author", equalTo(books.getAuthor()))
                .body("published_year", equalTo(books.getPublished_year()))
                .body("book_summary", equalTo(books.getBook_summary()));
    }

    @Category(BOOKS)
    @Test(description = "Verify that a book details cannot be updated without the authentication")
    public void testUpdateBooksWithoutAuthentication() {
        new RestClient(RESTFUL_BOOKER_BASE_URL, updateBookingEndpoint, Collections.emptyMap(),
                false, Collections.emptyMap(), updateBookingRequestJson)
                .sendRequest(PUT)
                .statusCode(SC_FORBIDDEN);
    }

    @Category(BOOKS)
    @Test(description = "Verify that a book details cannot be updated without the Id")
    public void testUpdateBooksWithoutRequiredParameters() {
        new RestClient(RESTFUL_BOOKER_BASE_URL, BOOKS_SERVICE_ENDPOINT, Collections.emptyMap(),
                true, Collections.emptyMap(), updateBookingRequestJson)
                .sendRequest(PUT)
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }
}

package com.restassured.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.example.Category;
import com.restassured.example.model.Books;
import com.restassured.example.util.RestClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.restassured.example.HttpMethod.POST;
import static com.restassured.example.constant.ApplicationConstant.*;
import static com.restassured.example.test.constant.TestCategory.BOOKS;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreateBooksTest extends BaseTest {
    private final Books books = new Books();
//    private final BookingRequest bookingRequest = new BookingRequest();
    private String createBookingRequestJson;

    @BeforeClass
    public void setCreateBookingRequestJson() {
        books.setPublished_year("2024-04-01");
        books.setId("3");
        books.setName("Rama");
        books.setAuthor("John");
        books.setBook_summary("fiction");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            createBookingRequestJson = objectMapper.writeValueAsString(books);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Category(BOOKS)
    @Test(description = "Verify that a new books creation can be raised")
    public void testCreateBooks() {
        new RestClient(RESTFUL_BOOKER_BASE_URL, BOOKS_SERVICE_ENDPOINT, Collections.emptyMap(),
                true, Collections.emptyMap(), createBookingRequestJson)
                .sendRequest(POST)
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .body("name", equalTo(books.getName()))
                .body("author", equalTo(books.getAuthor()))
                .body("published_year", equalTo(books.getPublished_year()))
                .body("book_summary", equalTo(books.getBook_summary()));
    }

    @Category(BOOKS)
    @Test(description = "Verify that a new book creation request cannot be raised without the required fields")
    public void testCreateBooksWithoutRequiredFields() {
        new RestClient(RESTFUL_BOOKER_BASE_URL, BOOKS_SERVICE_ENDPOINT, Collections.emptyMap(),
                true, Collections.emptyMap(), EMPTY)
                .sendRequest(POST)
                .statusCode(SC_UNPROCESSABLE_ENTITY);
    }
}

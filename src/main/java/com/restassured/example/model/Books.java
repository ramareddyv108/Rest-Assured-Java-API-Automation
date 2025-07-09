package com.restassured.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Books {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("published_year")
    private String published_year;

    @JsonProperty("book_summary")
    private String book_summary;

    public void setId(String id){
        this.id = id + Math.abs(UUID.randomUUID().toString().hashCode()) ;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPublished_year(String published_year){
        this.published_year = published_year;
    }

    public void setBook_summary(String book_summary){
        this.book_summary = book_summary;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return this.author;
    }
    public String getPublished_year(){
        return this.published_year;
    }
    public String getBook_summary(){
        return this.book_summary;
    }
}

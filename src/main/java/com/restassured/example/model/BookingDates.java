package com.restassured.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDates {

    @JsonProperty("checkin")
    private String checkIn;

    @JsonProperty("checkout")
    private String checkOut;

    public void setCheckIn(String checkIn){
        this.checkIn = checkIn;
    }
    public void setCheckOut(String checkOut){
        this.checkOut = checkOut;
    }

    public String getCheckIn(){
        return this.checkIn;
    }
    public String getCheckOut(){
        return this.checkOut;
    }
}

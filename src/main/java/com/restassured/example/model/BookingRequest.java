package com.restassured.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("totalprice")
    private int totalPrice;

    @JsonProperty("depositpaid")
    private boolean depositPaid;

    @JsonProperty("bookingdates")
    private BookingDates bookingDates;

    @JsonProperty("additionalneeds")
    private String additionalNeeds;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }

    public void setDepositPaid(boolean depositPaid){
        this.depositPaid = depositPaid;
    }

    public void setBookingDates(BookingDates bookingDates){
        this.bookingDates = bookingDates;
    }

    public void setAdditionalNeeds(String additionalNeeds){
        this.additionalNeeds = additionalNeeds;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int  getTotalPrice(){
        return this.totalPrice;
    }

    public boolean isDepositPaid(){
        return this.depositPaid ;
    }

    public String  getAdditionalNeeds(){
        return this.additionalNeeds;
    }
}

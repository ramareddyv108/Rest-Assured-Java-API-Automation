package com.restassured.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IDCreationRequest {
    private String id;
    private String username;
    private String password;
    public void setId(String id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getId(){
        return this.id;
    }
    public String getUsername(){
        return  this.username;
    }
    public String  getPassword(){
        return this.password;
    }
}

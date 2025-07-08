package com.restassured.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String username;
    private String password;
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
       return  this.username;
    }
    public String  getPassword(){
        return this.password;
    }
}

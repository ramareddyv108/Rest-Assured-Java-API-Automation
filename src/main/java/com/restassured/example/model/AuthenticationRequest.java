package com.restassured.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private int id;
    private String email;
    private String password;
    public void setId(int id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getId(){
        return this.id;
    }
    public String getEmail(){
       return  this.email;
    }
    public String  getPassword(){
        return this.password;
    }
}

package com.demo.userinfo.api.arguments;

public class GetAllArguments {
    private String street = "";

    public GetAllArguments() {
    }

    public GetAllArguments(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

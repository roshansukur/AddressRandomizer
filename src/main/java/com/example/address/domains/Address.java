package com.example.address.domains;

import lombok.Data;

@Data
public class Address {

    private String house;
    private String street;
    private String postalCode;
    private String city;
    private String county;
    private String state;
    private String stateCode;
    private String country;
    private String countryCode;

}

package com.example.address.controller;

import com.example.address.domains.Address;
import com.example.address.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/randomizer/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> getAddress() {
        new Address();
        Address response;
        response = addressService.getRandomAddress();
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

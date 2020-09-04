package com.example.address.serviceimpl;

import com.example.address.config.AppConfig;
import com.example.address.domains.Address;
import com.example.address.service.AddressService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

    private final Random rand = new Random();

    @Autowired
    AppConfig appConfig;

    @Override
    public Address getRandomAddress() {
        Address address = new Address();
        Faker faker = new Faker();
        List<String> list = Stream.of(appConfig.getCountry().split(",")).map(String::trim).collect(Collectors.toList());
        address.setHouse(faker.address().buildingNumber());
        address.setStreet(faker.address().streetName());
        address.setPostalCode(faker.address().zipCode());
        address.setCity(faker.address().city());
        address.setCounty(faker.address().cityName());
        address.setState(faker.address().state());
        address.setStateCode(faker.address().zipCode());
        address.setCountry(list.get(this.rand.nextInt(list.size())));
        address.setCountryCode(faker.address().countryCode());
        return address;
    }

}

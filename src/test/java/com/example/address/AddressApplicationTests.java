package com.example.address;

import com.example.address.config.AppConfig;
import com.example.address.domains.Address;
import com.example.address.serviceimpl.AddressServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {AddressServiceImpl.class, AppConfig.class}
)
@AutoConfigureMockMvc
@Slf4j
public class AddressApplicationTests {

    @Autowired
    AppConfig appConfig;
    @Autowired
    private AddressServiceImpl addressService;

    @Test
    void testAddress() {

        Address getRandomAddress = addressService.getRandomAddress();
        log.info(String.valueOf(getRandomAddress));
        assertNotNull(getRandomAddress.getHouse());
        assertNotNull(getRandomAddress.getStreet());
        assertNotNull(getRandomAddress.getPostalCode());
        assertNotNull(getRandomAddress.getCity());
        assertNotNull(getRandomAddress.getCounty());
        assertNotNull(getRandomAddress.getState());
        assertNotNull(getRandomAddress.getStateCode());
        assertNotNull(getRandomAddress.getCountry());
        assertNotNull(getRandomAddress.getCountryCode());
    }

}

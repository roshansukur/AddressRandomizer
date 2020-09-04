package com.example.address.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customConfig() {
        return new OpenAPI().components(new Components()).info(new Info().title("Generate Random Address").description("This is for generating random fake addresses which can be used for test data"));
    }
}

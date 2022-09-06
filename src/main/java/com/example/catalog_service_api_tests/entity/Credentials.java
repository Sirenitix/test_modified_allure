package com.example.catalog_service_api_tests.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "catalog")
@Configuration("catalogProperties")
@Data
public class Credentials {

    private String login;

    private String password;


}

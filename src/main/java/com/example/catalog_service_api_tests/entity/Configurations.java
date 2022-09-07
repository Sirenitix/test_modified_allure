package com.example.catalog_service_api_tests.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "catalog")
@Configuration("catalogProperties")
@Data
public class Configurations {

    private String login;

    private String password;

    private String baseUri;

    private String featureHandbookPath;

    private String signIn;

    private String featureHandbookWithParamPath;

    private String featureHandbookWithLimitPath;

    private String featureHandbookWithOffsetPath;


}

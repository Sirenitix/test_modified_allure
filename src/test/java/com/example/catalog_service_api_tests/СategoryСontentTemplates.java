package com.example.catalog_service_api_tests;


import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@Slf4j
@SpringBootTest
public class СategoryСontentTemplates {


    @Autowired
    private Configurations configurations;

    private static RequestSpecification requestSpecification;


    @BeforeEach
    public void setup(){
        RestAssured.baseURI = configurations.getBaseUri();
        Response response = given()
                .log()
                .all()
                .params("login", configurations.getLogin(), "password", configurations.getPassword())
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .log()
                .body()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();

    }


    @Test
    @DisplayName("Feature Handbook Api Test")
    public void featureHandbook(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbook())
                .then()
                .assertThat()
                .statusCode(200);
    }

}

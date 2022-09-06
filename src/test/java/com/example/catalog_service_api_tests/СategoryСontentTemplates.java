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
import static org.hamcrest.Matchers.*;


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
                .params("login", configurations.getLogin(), "password", configurations.getPassword())
                .post(configurations.getSignIn())
                .then()
                .log()
                .body()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();

    }


    @Test
    @DisplayName("get feature handbook test")
    public void featureHandbook(){
        given()
                .log().all()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("success", is(true));
    }



}

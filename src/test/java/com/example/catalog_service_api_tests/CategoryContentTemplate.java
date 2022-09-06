package com.example.catalog_service_api_tests;


import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@Slf4j
public class CategoryContentTemplate extends AbstractTest {

    @Override
    @BeforeEach
    public void setup() {
        super.setup();
    }

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("get feature handbook status code and status value")
    public void featureHandbook(){
        given()
                .log().all()
                .when()
                .spec(AbstractTest.requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("success", is(true));
    }

}

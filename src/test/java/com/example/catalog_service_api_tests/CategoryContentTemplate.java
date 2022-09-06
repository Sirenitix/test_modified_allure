package com.example.catalog_service_api_tests;


import com.example.catalog_service_api_tests.entity.Configurations;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

;


@Slf4j
public class CategoryContentTemplate extends AbstractTest {

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("get feature handbook status code and status value")
    public void featureHandbook(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("success", is(true));
    }


    @Test
    @Order(1)
    @DisplayName("asserts that the list of categories is empty when parameter is wrong")
    public void notEmptyList(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithParamPath() + wrongParameter)
                .then()
                .statusCode(400);
    }

    @Test
    @Order(2)
    @DisplayName("asserts that the list of categories has pagination.")
    public void thereIsAPagination(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .body("data.params.page" , is(instanceOf(Integer.class)));
    }


}

package com.example.catalog_service_api_tests;


import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


;


@Slf4j
public class CategoryContentTemplate extends AbstractTest {

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("check feature handbook's status code and status value")
    public void featureHandbook(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("success", is(true));
    }


    @Test
    @Order(1)
    @DisplayName("request with wrong parameter should return 400")
    public void notEmptyList(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithParamPath() + wrongParameter)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Order(2)
    @DisplayName("check for existence of pagination")
    public void thereIsAPagination(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .body("data.params.page" , is(instanceOf(Integer.class)));
    }

    @Test
    @Order(3)
    @DisplayName("check for right limit")
    public void rightALimit(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithLimitPath() + rigthPageNumber)
                .then()
                .body("data.params.items_per_page" , is(rigthPageNumber));
    }


    @Test
    @Order(4)
    @DisplayName("then the item not exist")
    public void notFound(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithLimitPath() + wrongPageNumber)
                .then()
                .assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    @Order(5)
    @DisplayName("checking for sorting order")
    public void isSorted(){
       Response response = given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .extract()
                .response();
       JsonPath jsonPath = response.getBody().jsonPath();
       List<Long> data = jsonPath.getList("data.data.id");
       List<Long> sortedData = new ArrayList<>(data);
       sortedData.sort(Comparator.naturalOrder());
       assertThat(data).isEqualTo(sortedData);

    }





}

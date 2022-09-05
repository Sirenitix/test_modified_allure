package com.example.catalog_service_api_tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;

public class Offers {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI="https://test4.jmart.kz/";
    }
    @Test
    @Order(1)
    @DisplayName("Returns the list of offers by product id")
    public void getListOfOffersByProductId(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.given().get("https://test4.jmart.kz/gw/catalog/v1/products/offers/100000").then().assertThat().body("success", is())
    }
}

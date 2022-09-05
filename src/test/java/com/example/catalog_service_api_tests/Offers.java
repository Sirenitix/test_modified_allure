package com.example.catalog_service_api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.core.Is.is;

@Slf4j
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
        requestSpecification.given().get("gw/catalog/v1/products/offers/1").then().assertThat().body("success", is(true));
    }
    @Test
    @Order(2)
    @DisplayName("Returns the list of offers by non valid product id")
    public void getListOfOffersByNonValidProductId(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.given().get("gw/catalog/v1/products/offers/wadawd");
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 404);
    }
}

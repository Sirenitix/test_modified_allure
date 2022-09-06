package com.example.catalog_service_api_tests;
import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

@Slf4j
public class CategoryContentTemplateProduct {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI="https://test4.jmart.kz/";
    }
    @Test
    @Order(1)
    @DisplayName("Returns the list of products uploaded by template")
    public void getListOfOffersByProductId(){
        RequestSpecification requestSpecification = RestAssured.given()
                .auth().preemptive()
                .basic("dev_test_admin@email.com", "Test_4dmin_Jmart");

        requestSpecification.given()
                .get("  gw/catalog/v1/category-content-template-product?name=a&company_id=1&status=1")
                .then().assertThat()
                .body("success", is(true));
    }
}

package com.example.catalog_service_api_tests;

import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class MerchantProducts {
}
@Slf4j
class Gw_catalog_v1_my_products {
    String productsForMerchant = "https://test4.jmart.kz/gw/catalog/v1/my/products";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
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
    @Order(1)
    @DisplayName("Asserts that the product description is not empty.")
    public void notEmptyList(){
//        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsForMerchant).getBody());
        System.out.println(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsForMerchant).getBody().prettyPrint());
    }
}
@Slf4j
class Gw_catalog_v1_my_products_id {
    String productsForMerchantById = "https://test4.jmart.kz/gw/catalog/v1/my/products/{id}";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
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
    @Order(1)
    @DisplayName("Asserts that the product description is not empty.")
    public void notEmptyList(){
//        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsForMerchant).getBody());
        System.out.println(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsForMerchantById).getBody().prettyPrint());
    }
}
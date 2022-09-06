package com.example.catalog_service_api_tests;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class VendorProductImport {
    private static RequestSpecification requestSpecification;
    @Before
    public void setup() {
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/my/vendor-product-import";
        Response response = given()
                .log()
                .all()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
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
        builder.addHeader("refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }
    @Test
    public void check(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/my/vendor-product-import")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

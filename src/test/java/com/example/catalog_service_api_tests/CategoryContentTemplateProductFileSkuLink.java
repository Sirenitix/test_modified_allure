package com.example.catalog_service_api_tests;
import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
public class CategoryContentTemplateProductFileSkuLink {
    private static RequestSpecification requestSpecification;
    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://test4.jmart.kz/";
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
    @Order(1)
    @DisplayName("Returns the info about products of uploaded file")
    public void getInfoAboutProductsOfUploadedFile(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/category/v1/category-content-template-product-file-sku-link?company_id=0&file_id=0")
                .then()
                .assertThat()
                .body("success", is(true));
        //API is closed.
        //"status": 403,
        //"error": "Access forbidden",
        //"message": "You don't have permission to access this resource"
    }
    @Test
    @Order(2)
    @DisplayName("Returns the info about products of uploaded file for merch")
    public void getInfoAboutProductsOfUploadedFileForMerch(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/category/v1/my/category-content-template-product-file-sku-link?company_id=0&file_id=0")
                .then()
                .assertThat()
                .body("success", is(true));
        //API is closed.
        //"status": 403,
        //"error": "Access forbidden",
        //"message": "You don't have permission to access this resource"
    }
}

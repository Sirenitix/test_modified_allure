package com.example.catalog_service_api_tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
@Slf4j
public class VendorProductImport extends AbstractTest {
    @Autowired
    @Test
    public void getMyImport() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .get("/my/vendor-product-import")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getMyImportById() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .get("/my/vendor-product-import")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getImport() {
        given()
                .when()
                .spec(requestSpecification)
                .get("/vendor-product-import")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

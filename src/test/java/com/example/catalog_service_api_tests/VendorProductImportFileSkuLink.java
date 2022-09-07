package com.example.catalog_service_api_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class VendorProductImportFileSkuLink extends AbstractTest{
    @Test
    public void getMyImportLink() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .get("/gw/catalog/v1/my/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getImportLink() {
        given()
                .when()
                .spec(requestSpecification)
                //.param("company_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(200);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 0)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

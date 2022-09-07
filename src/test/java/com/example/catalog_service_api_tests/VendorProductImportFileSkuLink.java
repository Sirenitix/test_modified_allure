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
                .param("company_id", 1)
                .param("file_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(200);
        given()
                .when()
                .param("company_id", 1)
                .param("file_id", 1)
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(401);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", "asd")
                .param("file_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(422);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 1)
                .param("file_id", "asd")
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(422);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 1.5)
                .param("file_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(422);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 1)
                .param("file_id", 1.5)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(422);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 1)
                .param("file_id", -1)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(422);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", -1)
                .param("file_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file-sku-link")
                .then()
                .assertThat()
                .statusCode(422);
    }
}

package com.example.catalog_service_api_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CatalogV2 extends AbstractTest{
    @Test
    public void postProductsByIds() {
        given()
                .when()
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "    0\n" +
                        "  ]\n" +
                        "}")
                .post("/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

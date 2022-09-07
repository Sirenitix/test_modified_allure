package com.example.catalog_service_api_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class VendorProductImportLink extends AbstractTest{
    @Test
    public void postImportLinkUpsert() {
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"data\": [\n" +
                        "    {\n" +
                        "      \"vendor_product_import_id\": 0,\n" +
                        "      \"product_code\": \"string\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file/upsert")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

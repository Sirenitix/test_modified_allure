package com.example.catalog_service_api_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CatalogV2 extends AbstractConfiguration{
    @Test
    public void postProductsByIds() {

//2 normal requests.
        given()
                .when()
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(200);

//4 non-valid requests.
        given()
                .when()
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "    dfvdfdg\n" +
                        "  ]\n" +
                        "}")
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "    1.5\n" +
                        "  ]\n" +
                        "}")
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(500);

        given()
                .when()
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "    \"adf\"\n" +
                        "  ]\n" +
                        "}")
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(500);

        given()
                .when()
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "  ]\n" +
                        "}")
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(500);

//Request without body.
        given()
                .when()
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(500);

//Empty body request.
        given()
                .when()
                .body("{\n" +
                        "}")
                .contentType("application/json")
                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
                .then()
                .assertThat()
                .statusCode(500);

        //Valid but non-exist id, not sure what system need to show in this scenario.
//        given()
//                .when()
//                .body("{\n" +
//                        "  \"ids\": [\n" +
//                        "    -1\n" +
//                        "  ]\n" +
//                        "}")
//                .contentType("application/json")
//                .post("https://test4.jmart.kz/gw/catalog/v2/products/by_ids")
//                .then()
//                .assertThat()
//                .statusCode(500);
    }
}

package com.example.catalog_service_api_tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
@Slf4j
public class VendorProductImport extends AbstractTest {
    @Test
    public void getMyImport() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .get("/gw/catalog/v1/my/vendor-product-import")
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
                .get("/gw/catalog/v1/my/vendor-product-import/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void putMyImportById() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .body("{\n" +
                        "  \"model\": \"string\",\n" +
                        "  \"brand\": \"string\",\n" +
                        "  \"product_code\": \"string\"\n" +
                        "}")
                .put("/gw/catalog/v1/my/vendor-product-import/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void putMyImportClarifyById() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .body("{\n" +
                        "  \"file\": \"string\",\n" +
                        "  \"send_to_moderation\": 0,\n" +
                        "  \"link_product_code\": \"string\",\n" +
                        "  \"product_code\": \"string\"\n" +
                        "}")
                .put("/gw/catalog/v1/my/vendor-product-import/clarify/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postMyImportChild() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .post("/gw/catalog/v1/my/vendor-product-import/create-child-product")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postMyImportImport() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .post("/gw/catalog/v1/my/vendor-product-import/import")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postMyImportMapping() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .post("/gw/catalog/v1/my/vendor-product-import/mapping")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getMyImportStatus(){
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 0)
                .get("/gw/catalog/v1/my/vendor-product-import/process-status")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void putMyImportDetachById() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .put("/gw/catalog/v1/my/vendor-product-import/product-detach/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void putMyImportChangeById() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .body("{\n" +
                        "  \"status\": 0\n" +
                        "}")
                .put("/gw/catalog/v1/my/vendor-product-import/status-change/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postMyImportQueueById() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .post("/gw/catalog/v1/my/vendor-product-import/to-queue/1")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    public void getImport() {
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getImportById() {
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void putImportById() {
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"model\": \"string\",\n" +
                        "  \"brand\": \"string\",\n" +
                        "  \"product_code\": \"string\"\n" +
                        "}")
                .put("/gw/catalog/v1/vendor-product-import/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void putImportClarifyById() {
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file\": \"string\",\n" +
                        "  \"send_to_moderation\": 0,\n" +
                        "  \"link_product_code\": \"string\",\n" +
                        "  \"product_code\": \"string\"\n" +
                        "}")
                .put("/gw/catalog/v1/vendor-product-import/clarify/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postImportChild() {
        given()
                .when()
                .spec(requestSpecification)
                .post("/gw/catalog/v1/vendor-product-import/create-child-product")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postImportImport() {
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file\": \"string\",\n" +
                        "  \"company_id\": 0\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import/import")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    public void postImportMapping() {
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file\": \"string\",\n" +
                        "  \"company_id\": 0\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import/mapping")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    public void putImportDetachById() {
        given()
                .when()
                .spec(requestSpecification)
                .put("/gw/catalog/v1/vendor-product-import/product-detach/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void putImportChangeById() {
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"status\": 0\n" +
                        "}")
                .put("/gw/catalog/v1/vendor-product-import/status-change/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postImportQueue() {
        given()
                .when()
                .spec(requestSpecification)
                .post("/gw/catalog/v1/vendor-product-import/to-queue-all")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    public void postImportQueueById() {
        given()
                .when()
                .spec(requestSpecification)
                .post("/gw/catalog/v1/vendor-product-import/to-queue/1")
                .then()
                .assertThat()
                .statusCode(201);
    }
}

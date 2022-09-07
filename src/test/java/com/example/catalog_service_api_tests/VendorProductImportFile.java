package com.example.catalog_service_api_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class VendorProductImportFile extends AbstractTest{
    @Test
    public void getMyImportFile() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .get("/gw/catalog/v1/my/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getMyImportFileById() {
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .get("/gw/catalog/v1/my/vendor-product-import-file/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getImportFile() {
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(200);
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(200);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", "asfjkbi")
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(422);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", -25)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(404);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 2.5)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(404);
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postImportFile(){
        given()
                .when()
                .body("{\n" +
                        "  \"file_id\": 0,\n" +
                        "  \"company_id\": 0\n" +
                        "}")
                .post("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(401);
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file_id\": 0,\n" +
                        "  \"company_id\": 0\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getImportFileById() {
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file/1")
                .then()
                .assertThat()
                .statusCode(200);
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file/'asdas'")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file/1.5")
                .then()
                .assertThat()
                .statusCode(404);
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file/-1")
                .then()
                .assertThat()
                .statusCode(404);
        given()
                .when()
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file/1")
                .then()
                .assertThat()
                .statusCode(401);
    }
    @Test
    public void getImportFileLast() {
        //This endpoint only return 500.
        given()
                .when()
                .spec(requestSpecification)
                .param("Company_Id", -1)
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .param("Company_Id", 2.5)
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .param("Company_Id", "ahfgisahf")
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .param("Company_Id", 1)
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(200);

    }
    @Test
    public void getImportFileLastById() {
        //This endpoint only returns 404.
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file/last/0")
                .then()
                .assertThat()
                .statusCode(200);
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file/last/-1")
                .then()
                .assertThat()
                .statusCode(400);
        given()
                .when()
                .spec(requestSpecification)
                .param("Company_Id", 2.5)
                .get("/gw/catalog/v1/vendor-product-import-file/last/2.5")
                .then()
                .assertThat()
                .statusCode(400);
        given()
                .when()
                .spec(requestSpecification)
                .param("Company_Id", "ahfgisahf")
                .get("/gw/catalog/v1/vendor-product-import-file/last/sdad")
                .then()
                .assertThat()
                .statusCode(400);
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file/last/1")
                .then()
                .assertThat()
                .statusCode(400);
    }
    @Test
    public void getMyImportFileReport() {
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/my/vendor-product-import-file/report")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

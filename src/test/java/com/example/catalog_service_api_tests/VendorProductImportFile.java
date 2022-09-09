package com.example.catalog_service_api_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class VendorProductImportFile extends AbstractConfiguration{
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
//Normal request.
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(200);

//Non-authorized request.
        given()
                .when()
                .param("company_id", 1)
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(401);

//Only required params.
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(200);

//Next 2 tests with non-valid params.
        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", "asfjkbi")
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);

        given()
                .when()
                .spec(requestSpecification)
                .param("company_id", 2.5)
                .get("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);

//Valid but non-exist ids, not sure what system need to show in this scenario.
//        given()
//                .when()
//                .spec(requestSpecification)
//                .param("company_id", -25)
//                .get("/gw/catalog/v1/vendor-product-import-file")
//                .then()
//                .assertThat()
//                .statusCode(500);
    }
    @Test
    public void postImportFile(){

//Non-authorized request.
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

//Normal request.
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
                .statusCode(201);

//Empty body request.
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);

//Request without body.
        given()
                .when()
                .spec(requestSpecification)
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);

//Next 4 test with non-valid params.
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file_id\": \"sdf\",\n" +
                        "  \"company_id\": 0\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file_id\": 0,\n" +
                        "  \"company_id\": \"sdf\"\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file_id\": 1.5,\n" +
                        "  \"company_id\": 0\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file_id\": 0,\n" +
                        "  \"company_id\": 1.5\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);

//Valid but non-exist ids, not sure what system need to show in this scenario.
//        given()
//                .when()
//                .spec(requestSpecification)
//                .body("{\n" +
//                        "  \"file_id\": -1,\n" +
//                        "  \"company_id\": 0\n" +
//                        "}")
//                .post("/gw/catalog/v1/vendor-product-import-file")
//                .then()
//                .assertThat()
//                .statusCode(500);
//        given()
//                .when()
//                .spec(requestSpecification)
//                .body("{\n" +
//                        "  \"file_id\": 0,\n" +
//                        "  \"company_id\": -1\n" +
//                        "}")
//                .post("/gw/catalog/v1/vendor-product-import-file")
//                .then()
//                .assertThat()
//                .statusCode(500);

//Next 2 tests with only one of the required params.
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"company_id\": 0\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"file_id\": 0\n" +
                        "}")
                .post("/gw/catalog/v1/vendor-product-import-file")
                .then()
                .assertThat()
                .statusCode(500);
    }
    @Test
    public void getImportFileById() {
//Normal request.
        given()
                .when()
                .spec(requestSpecification)
                .pathParam("id", 1)
                .get("/gw/catalog/v1/vendor-product-import-file/{id}")
                .then()
                .assertThat()
                .statusCode(200);

//Non-authorized request.
        given()
                .when()
                .pathParam("id", 1)
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file/{id}")
                .then()
                .assertThat()
                .statusCode(401);

//Valid but not existed.
        given()
                .when()
                .spec(requestSpecification)
                .pathParam("id", -1)
                .get("/gw/catalog/v1/vendor-product-import-file/{id}")
                .then()
                .assertThat()
                .statusCode(500);

//Next 2 tests with non-valid params.
        given()
                .when()
                .spec(requestSpecification)
                .pathParam("id", "asd")
                .get("/gw/catalog/v1/vendor-product-import-file/{id}")
                .then()
                .assertThat()
                .statusCode(500);

        given()
                .when()
                .spec(requestSpecification)
                .pathParam("id", 1.5)
                .get("/gw/catalog/v1/vendor-product-import-file/{id}")
                .then()
                .assertThat()
                .statusCode(500);
    }
    @Test
    public void getImportFileLast() {
//Non-authorized request.
        given()
                .when()
                .param("Company-Id", 1)
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(401);
//Normal request.
         given()
                 .when()
                 .spec(requestSpecification)
                 .param("Company-Id", 1)
                 .get("/gw/catalog/v1/vendor-product-import-file/last")
                 .then()
                 .assertThat()
                 .statusCode(200);

//Valid, but non-existed param.
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", -1)
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);

//Next 2 tests with non-valid params.
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", 2.5)
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);
        given()
                .when()
                .spec(requestSpecification)
                .param("Company-Id", "ahfgisahf")
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);

//Request without one of required param.
        given()
                .when()
                .spec(requestSpecification)
                .get("/gw/catalog/v1/vendor-product-import-file/last")
                .then()
                .assertThat()
                .statusCode(500);
    }
    @Test
    public void getImportFileLastById() {
// Normal request.
        given()
                .when()
                .spec(requestSpecification)
                .pathParam("id", 0)
                .get("/gw/catalog/v1/vendor-product-import-file/last/{id}}")
                .then()
                .assertThat()
                .statusCode(200);

//Next 2 tests with non-valid param.
        given()
                .when()
                .spec(requestSpecification)
                .pathParam("id", 1.5)
                .get("/gw/catalog/v1/vendor-product-import-file/last/{id}")
                .then()
                .assertThat()
                .statusCode(400);

        given()
                .when()
                .spec(requestSpecification)
                .pathParam("id", "asfka")
                .get("/gw/catalog/v1/vendor-product-import-file/last/{id}")
                .then()
                .assertThat()
                .statusCode(500);

//Non-authorized request.
        given()
                .when()
                .pathParam("id", 1)
                .get("https://test4.jmart.kz/gw/catalog/v1/vendor-product-import-file/last/{id}")
                .then()
                .assertThat()
                .statusCode(401);

//Valid but non-exist ids, not sure what system need to show in this scenario.
//        given()
//                .when()
//                .spec(requestSpecification)
//                .pathParam("id", -1)
//                .get("/gw/catalog/v1/vendor-product-import-file/last/{id}")
//                .then()
//                .assertThat()
//                .statusCode(400);
    }
//    @Test
//    public void getMyImportFileReport() {
//        given()
//                .when()
//                .spec(requestSpecification)
//                .get("/gw/catalog/v1/my/vendor-product-import-file/report")
//                .then()
//                .assertThat()
//                .statusCode(200);
//    }
}

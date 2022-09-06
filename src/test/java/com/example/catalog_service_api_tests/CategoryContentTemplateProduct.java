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

@Slf4j
public class CategoryContentTemplateProduct {
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
    @DisplayName("Returns the list of products uploaded by template")
    public void getListOfProductsUploadedByTemplate(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product?name=a&company_id=1&status=1")
                .then()
                .assertThat()
                .body("success", is(true));
    }
    @Test
    @Order(2)
    @DisplayName("Returns the list of products uploaded by template with non valid Id and non valid status")
    public void getListOfProductsUploadedByTemplateByNonValidCompanyIdAndStatus(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product?name=a&company_id=awdaw&status=awdawd")
                .then()
                .assertThat()
                .body("success", is(false));
    }
    @Test
    @Order(3)
    @DisplayName("Returns the list of products uploaded by template with non exist Id and non exist status")
    public void getListOfProductsUploadedByTemplateByNonExistCompanyIdAndStatus(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product?name=awdawdawdawd&company_id=awdawdawdawdawd&status=1")
                .then()
                .assertThat()
                .body("success", is(false));
    }
    @Test
    @Order(4)
    @DisplayName("Returns the product uploaded by template by ID")
    public void getProductUploadedByTemplateByID(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/12311")
                .then()
                .assertThat()
                .body("success", is(true));
        System.out.println("Should be tested with real IDs");
    }
    @Test
    @Order(5)
    @DisplayName("Returns the product uploaded by template by Non valid ID")
    public void getProductUploadedByTemplateByNonValidID(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/awdawdawd")
                .then()
                .assertThat()
                .body("success", is(false));
        System.out.println("Error status 500: INTERNAL_SERVER_ERROR");
    }
    @Test
    @Order(6)
    @DisplayName("Returns the product uploaded by template by Non exist ID")
    public void getProductUploadedByTemplateByNonExistID(){
        given()
                .when()
                .spec(requestSpecification)
                .get("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/667667667")
                .then()
                .assertThat()
                .body("success", is(false));
        System.out.println("Something strange returns");
    }
    @Test
    @Order(7)
    @DisplayName("Change the name and product code of the product by Id")
    public void putNameAndProductCodeOfTheProductById(){
        String name = "PyleS.O.S Xuyomi";
        String product_code = "667wws667wws";
        given()
                .when()
                .spec(requestSpecification)
                .body("{ \"data.product\": \"" + name + "\"}")
                .put("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/1670296")
                .then()
                .assertThat()
                .body("data.product", is("PyleS.O.S Xuyomi"));
        //This API request is done wrong. It asks for name and product code whearas they cannot be found anywhere
    }
    @Test
    @Order(8)
    @DisplayName("Clarify the product of salesman")
    public void putClarifyProductOfSalesman(){
        String file = "PyleS.O.S Xuyomi";
        String product_code = "667wws667wws";
        given()
                .when()
                .spec(requestSpecification)
                .body("{ \"data.product\": \"" + file + "\"}")
                .put("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/clarify/1670296")
                .then()
                .assertThat()
                .body("file", is("PyleS.O.S Xuyomi"));
        //This API request is done wrong. It asks for file, send_to_moderation, link_product_code, product_code whearas they cannot be found anywhere
    }
    @Test
    @Order(9)
    @DisplayName("Create child product of product")
    public void postCreateChildProductOfProduct(){
        RequestSpecification responseSpecification = given();
        Response response= responseSpecification.given()
                .when()
                .post("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/create-child-product");
        Assert.assertEquals(200, response.getStatusCode());
        //This API request is done wrong. It does not asks for product Id
    }
    @Test
    @Order(10)
    @DisplayName("Importing file with products")
    public void postImportFileWithProducts(){
        String file = "dawdawd";
        int company_id= 123;
        given()
                .when()
                .spec(requestSpecification)
                .body("{ \"file\": \"" + file + "\", \"company_id\": \"" + company_id + "\"}")
                .post("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/import")
                .then()
                .assertThat()
                .body("file", is("dawdawd"));
        //This API request is done correctly. Validation works correctly. Asks for the specific type of file for "file" field
    }
    @Test
    @Order(11)
    @DisplayName("Detaching the product of seller")
    public void putDetachingTheProductOfSeller(){
        RequestSpecification responseSpecification = given();
        Response response= responseSpecification.given()
                .when()
                .put("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/product-detach/1670296");
        Assert.assertEquals(200, response.getStatusCode());
        //This API request is done wrong. It does not searches for the product. Error 404 returns
    }
    @Test
    @Order(12)
    @DisplayName("Change the status of a product")
    public void putChangeTheStatusOfProduct(){
        String status = "A";
        String product_code = "667wws667wws";
        given()
                .when()
                .spec(requestSpecification)
                .body("{ \"status\": \"" + status + "\"}")
                .put("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/status-change/1670296")
                .then()
                .assertThat()
                .body("status", is("A"));
        //This API request is done wrong. It does not searches for the product. Error 404 returns
    }
    @Test
    @Order(12)
    @DisplayName("Change the status of a product")
    public void putChangeTheStatusOfProduct(){
        String status = "A";
        String product_code = "667wws667wws";
        given()
                .when()
                .spec(requestSpecification)
                .body("{ \"status\": \"" + status + "\"}")
                .put("https://test4.jmart.kz/gw/catalog/v1/category-content-template-product/status-change/1670296")
                .then()
                .assertThat()
                .body("status", is("A"));
        //This API request is done wrong. It does not searches for the product. Error 404 returns
    }
}

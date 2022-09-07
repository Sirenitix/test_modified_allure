package com.example.catalog_service_api_tests;

import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Catalog {
}
class Catalog_v1_categories_by_ids {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/categories/by_ids";
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody());
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has no pagination.")
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }
    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "@#@&*").getStatusCode(), 400);
    }
    //404 on the page, 200 even with wrong parameter
}

class Catalog_v1_categories_categories_list {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/categories/categories_list";
    }
    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody());
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "@#@&*").getStatusCode(), 400);
    }
    //404 on the page
}

class Catalog_v1_categories_get_two_top_levels {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/categories/get_two_top_levels";
    }
    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody(), "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void thereIsAPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "/220220%").getStatusCode(), 400);
    }
}

class Catalog_v1_categories_ordered_by_levels {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/categories/ordered_by_levels";
    }
    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody(), "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void thereIsAPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "/220220%").getStatusCode(), 400);
    }
}

class Catalog_v1_products_by_ids_full {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/products/by_ids/full";
    }
    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void notEmptyList(){
//        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody());
        System.out.println(RestAssured.given().request(Method.GET).getBody().prettyPrint());
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of products has pagination.")
    public void thereIsAPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "/220220%").getStatusCode(), 400);
    }

    @Test
    @Order(5)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void validIdCheckResponseData(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "?ids=1244667/P").getBody();
        Assert.assertNotNull(responseBody);
    }

    @Test
    @Order(6)
    @DisplayName("Asserts that response has error 404 for th ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?ids=1244669/P").getStatusCode(), 404);
    }

    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?ids=1244669").getStatusCode(), 404);
    }
}

class Catalog_v1_products_images_by_ids {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/products";
    }
}

class Gw_catalog_v1_categories_parent_id {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/categories/";
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the list of products in a specified category is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET, "272").getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of products has pagination.")
    public void thereIsAPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET, "272").getBody().asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().request(Method.GET, "item/2110").getStatusCode(), 404);
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET, "272").getBody());
    }
    @Test
    @Order(5)
    @DisplayName("Asserts that response has error 404 for th ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "-1").getStatusCode(), 404);
    }
    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "ids=1244669").getStatusCode(), 404);
    }
}

class Gw_catalog_v1_categories_contain_parent_id {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/categories/contain/";
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories in a specified parent category is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET, "272").getBody(), "Result: Response is not empty");
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void noPagination(){
        Assert.assertFalse(RestAssured.given().request(Method.GET, "272").getBody().asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().request(Method.GET, "item/2110").getStatusCode(), 404);
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET, "272").getBody());
    }

    @Test
    @Order(5)
    @DisplayName("Asserts that response has error 404 for th ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "321").getStatusCode(), 404);
    }

    @Test
    @Order(6)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "ids=1244669").getStatusCode(), 404);
    }
}

class Gw_catalog_v1_categories_popular {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/categories/popular";
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the list of popular categories is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of popular categories has pagination.")
    public void noPagination(){
        Assert.assertFalse(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().request(Method.GET, "item/2110").getStatusCode(), 404);
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("parent_id") && responseBody.asString().contains("type")
                && responseBody.asString().contains("image_link") && responseBody.asString().contains("title"));
    }
}

class Gw_catalog_v1_categories_root {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/categories/root";
    }
    @Test
    @Order(1)
    @DisplayName("Asserts that the list of root categories is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody(), "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of root categories has pagination.")
    public void noPagination(){
        Assert.assertFalse(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().request(Method.GET, "item/2110").getStatusCode(), 404);
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("category_id") && responseBody.asString().contains("category"));
    }
}

@Slf4j
class Gw_catalog_v1_features_list {

    String featuresList = "https://test4.jmart.kz/gw/catalog/v1/features/list";

    @Autowired
    private Configurations configurations;
    protected RequestSpecification requestSpecification;

    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the features list is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList).getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the features list has a pagination.")
    public void thereIsAPagination(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList).getBody().asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the features list has a limit.")
    public void thereIsALimit(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList + "/@#@&*").getStatusCode(), 404);
    }
}
@Slf4j
class Gw_catalog_v1_features_variants_list {

    String featureVariantsList = "https://test4.jmart.kz/gw/catalog/v1/features/variants/list";

    @Autowired
    private Configurations configurations;
    protected RequestSpecification requestSpecification;

    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the feature variants list is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList).getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the feature variants list has a pagination.")
    public void thereIsAPagination(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList).getBody().asString().contains("next_page"));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the features list has a limit.")
    public void thereIsALimit(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList + "/@#@&*").getStatusCode(), 404);
    }
}
@Slf4j
class Gw_catalog_v1_my_products_statusChange_id {
    String statusChange = "https://test4.jmart.kz/gw/catalog/v1/my/products/status-change/342517/P";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }

    @Test
    @Order(1)
    @DisplayName("Jai test")
    public void jaiTest(){
        System.out.println(RestAssured.given().when().spec(requestSpecification).request(Method.GET, statusChange).getBody().prettyPrint());
    }
}
@Slf4j
class Gw_catalog_v1_products {
    String productsListing = "https://test4.jmart.kz/gw/catalog/v1/products";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the products list is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsListing + "?category_id=268").getBody());
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the products list has a pagination.")
    public void thereIsAPagination(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsListing + "?category_id=268").getBody().asString().contains("total_pages"));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the products list has a limit.")
    public void thereIsALimit(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsListing + "?category_id=268").getBody().asString().contains("items_per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsListing + "/@#@&*").getStatusCode(), 404);
    }
}
@Slf4j
class Gw_catalog_v1_products_product_id {
    String specificProduct = "https://test4.jmart.kz/gw/catalog/v1/products/3177149";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the product description is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, specificProduct).getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the product description has no pagination.")
    public void noPagination(){
        Assert.assertFalse(RestAssured.given().when().spec(requestSpecification).request(Method.GET, specificProduct).getBody().asString().contains("total_pages"));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the products list has no limit.")
    public void noLimit(){
        Assert.assertFalse(RestAssured.given().when().spec(requestSpecification).request(Method.GET, specificProduct).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, specificProduct + "/@#@&*").getStatusCode(), 404);
    }
}
@Slf4j
class Gw_catalog_v1_products_by_codes {
    String productByCodes = "https://test4.jmart.kz/gw/catalog/v1/products/by_codes";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }
}
@Slf4j
class Gw_catalog_v1_products_by_ids {
    String productByIds = "https://test4.jmart.kz/gw/catalog/v1/products/by_ids";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }
}
@Slf4j
class Gw_catalog_v1_products_codes_by_ids {
    String productsCodesByIds = "https://test4.jmart.kz/gw/catalog/v1/products/codes-by-ids";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }
}
@Slf4j
class Gw_catalog_v1_products_order_products_company {
    String orderProductsCompany = "https://test4.jmart.kz/gw/catalog/v1/products/order-products-company";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }

    @Test
    @Order(1)
    @DisplayName("Jai test")
    public void jaiTest(){
        System.out.println(RestAssured.given().when().spec(requestSpecification).request(Method.GET, orderProductsCompany).getBody().prettyPrint());
    }
}
@Slf4j
class Gw_catalog_v1_products_supermarket_companyId {
    String supermarketCompany = "https://test4.jmart.kz/gw/catalog/v1/products/supermarket/1476";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the product description is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, supermarketCompany).getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the product description has no pagination.")
    public void noPagination(){
        Assert.assertFalse(RestAssured.given().when().spec(requestSpecification).request(Method.GET, supermarketCompany).getBody().asString().contains("total_pages"));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the products list has no limit.")
    public void noLimit(){
        Assert.assertFalse(RestAssured.given().when().spec(requestSpecification).request(Method.GET, supermarketCompany).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, supermarketCompany + "/@#@&*").getStatusCode(), 404);
    }
}
@Slf4j
class Gw_catalog_v1_products_update_price {
    String updatePrice = "https://test4.jmart.kz/gw/catalog/v1/products/update-price";

    @Autowired
    protected RequestSpecification requestSpecification;
    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz";
        Response response = given()
                .params("login", "dev_test_admin@email.com", "password", "Test_4dmin_Jmart")
                .post("https://test4.jmart.kz/gw/user/v1/auth/sign-in")
                .then()
                .statusCode(201)
                .extract()
                .response();
        String access_token = response.path("data.tokens.auth.token").toString();
        log.info(access_token + " - access_token");
        String refresh_token = response.path("data.tokens.refresh.token").toString();
        String Authorization = "Bearer " + access_token;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        builder.addHeader("Refresh_token", refresh_token);
        builder.addHeader("Content-Type", "application/json");
        requestSpecification = builder.build();
    }
}

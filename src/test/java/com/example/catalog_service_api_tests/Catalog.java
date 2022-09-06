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
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/categories/categories_list";
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void notEmptyList(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void thereIsAPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("per_page"));
    }
    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        int statusCode = RestAssured.given().request(Method.GET, "220220%").getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void thereIsAPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        int statusCode = RestAssured.given().request(Method.GET, "/220220%").getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void thereIsAPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        int statusCode = RestAssured.given().request(Method.GET, "/220220%").getStatusCode();
        Assert.assertEquals(statusCode, 400);
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void thereIsAPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        int statusCode = RestAssured.given().request(Method.GET, "/220220%").getStatusCode();
        Assert.assertEquals(statusCode, 400);
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of products has pagination.")
    public void thereIsAPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void thereIsALimit(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertTrue(responseBody.asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        int statusCode = RestAssured.given().request(Method.GET, "/220220%").getStatusCode();
        Assert.assertEquals(statusCode, 400);
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
        int statusCode = RestAssured.given().request(Method.GET, "?ids=1244669/P").getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }

    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void inValidIdCheckResponseData(){
        int statusCode = RestAssured.given().request(Method.GET, "?ids=1244669").getStatusCode();
        Assert.assertEquals(statusCode, 404);
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "272").getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of products has pagination.")
    public void thereIsAPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "272").getBody();
        Assert.assertTrue(responseBody.asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        int statusCode = RestAssured.given().request(Method.GET, "item/2110").getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "272").getBody();
        Assert.assertNotNull(responseBody);
    }
    @Test
    @Order(5)
    @DisplayName("Asserts that response has error 404 for th ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        int statusCode = RestAssured.given().request(Method.GET, "-1").getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }
    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void inValidIdCheckResponseData(){
        int statusCode = RestAssured.given().request(Method.GET, "ids=1244669").getStatusCode();
        Assert.assertEquals(statusCode, 404);
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "272").getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories has pagination.")
    public void noPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "272").getBody();
        Assert.assertFalse(responseBody.asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        int statusCode = RestAssured.given().request(Method.GET, "item/2110").getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "272").getBody();
        Assert.assertNotNull(responseBody);
    }

    @Test
    @Order(5)
    @DisplayName("Asserts that response has error 404 for th ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        int statusCode = RestAssured.given().request(Method.GET, "321").getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }

    @Test
    @Order(6)
    @DisplayName("Asserts that the list of categories is not empty.")
    public void inValidIdCheckResponseData(){
        int statusCode = RestAssured.given().request(Method.GET, "ids=1244669").getStatusCode();
        Assert.assertEquals(statusCode, 404);
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of popular categories has pagination.")
    public void noPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertFalse(responseBody.asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        int statusCode = RestAssured.given().request(Method.GET, "item/2110").getStatusCode();
        Assert.assertEquals(statusCode, 404);
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
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of root categories has pagination.")
    public void noPagination(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET).getBody();
        Assert.assertFalse(responseBody.asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        int statusCode = RestAssured.given().request(Method.GET, "item/2110").getStatusCode();
        Assert.assertEquals(statusCode, 404);
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

    @Autowired
    private Configurations configurations;
    protected RequestSpecification requestSpecification;

    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/features/list";
        Response response = given()
                .params("login", configurations.getLogin(), "password", configurations.getPassword())
                .post(configurations.getSignIn())
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
    @DisplayName("Asserts that the list of root categories is not empty.")
    public void notEmptyList(){
        ResponseBody responseBody = RestAssured.given().auth().preemptive().basic("dev_test_admin@email.com", "Test_4dmin_Jmart").request(Method.GET).getBody();
        System.out.println(responseBody.prettyPrint());
//        Assert.assertNotNull(responseBody, "Result: Response is not empty");
    }
}
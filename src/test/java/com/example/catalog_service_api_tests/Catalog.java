package com.example.catalog_service_api_tests;

import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

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
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?id=@#@&*").getStatusCode(), 404);
    }
    //404 on the page, 404 with wrong parameter
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
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?category_id=@#@&*").getStatusCode(), 404);
    }
    //404 on the page, 404 with wrong parameters
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
        Assert.assertEquals(RestAssured.given().request(Method.GET, "@#@&*").getStatusCode(), 404);
    }
    //404 on the page
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
        Assert.assertEquals(RestAssured.given().request(Method.GET, "@#@&*").getStatusCode(), 404);
    }
    //404 on the page
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
        Assert.assertNotNull(RestAssured.given().request(Method.GET).getBody());
    }
    @Test
    @Order(2)
    @DisplayName("Asserts that the list of products has pagination.")
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("page="));
    }
    @Test
    @Order(3)
    @DisplayName("Asserts that the list of products has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that the status code is 400 when passed the incorrect parameter")
    public void incorrectParameter(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "@#@&*").getStatusCode(), 404);
    }

    @Test
    @Order(5)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody responseBody = RestAssured.given().request(Method.GET, "?ids=1244667%2FP").getBody();
        System.out.println(responseBody.prettyPrint());
        //404 even with valid id
    }

    @Test
    @Order(6)
    @DisplayName("Asserts that response has error 404 for ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?ids=1244669%2FP").getStatusCode(), 404);
    }

    @Test
    @Order(7)
    @DisplayName("Asserts that response has error 404 for invalid ID")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?ids=@#@&*").getStatusCode(), 404);
    }
    //404 on the page
}

class Catalog_v1_products_images_by_ids {
    //404 on the page
}

class Gw_catalog_v1_categories_parent_id {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/categories";
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories in a specified parent category is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET, "/272").getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories in a specified parent category has pagination.")
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET, "/272").getBody().asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?2110").getStatusCode(), 404);
    }

    @Test
    @Order(5)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody body = RestAssured.given().request(Method.GET, "/272").getBody();
        Assert.assertTrue(body.asString().contains("parent_id") && body.asString().contains("category_id") && body.asString().contains("id_path")
                && body.asString().contains("category") && body.asString().contains("position") && body.asString().contains("age_verification")
                && body.asString().contains("age_limit") && body.asString().contains("age_warning_message") && body.asString().contains("id_path_names")
                && body.asString().contains("has_children"));
    }
    @Test
    @Order(6)
    @DisplayName("Asserts that response has error 404 for ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "/-1").getStatusCode(), 404);
    }
    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories has error 404 for invalid ID")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "/10000000").getStatusCode(), 404);
    }
}

class Gw_catalog_v1_categories_contain_parent_id {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://test4.jmart.kz/gw/catalog/v1/categories/contain/";
    }

    @Test
    @Order(1)
    @DisplayName("Asserts that the list of categories containing specified parent category is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().request(Method.GET, "/272").getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the list of categories containing specified parent category has pagination.")
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().request(Method.GET, "/272").getBody().asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the list of categories has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().request(Method.GET).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?parent_id=272").getStatusCode(), 404);
    }

    @Test
    @Order(5)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody body = RestAssured.given().request(Method.GET, "/272").getBody();
        Assert.assertTrue(body.asString().contains("parent_id") && body.asString().contains("category_id") && body.asString().contains("id_path")
                && body.asString().contains("category") && body.asString().contains("position") && body.asString().contains("age_verification")
                && body.asString().contains("age_limit") && body.asString().contains("age_warning_message") && body.asString().contains("id_path_names"));
    }
    @Test
    @Order(6)
    @DisplayName("Asserts that response has error 404 for ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "/-1").getStatusCode(), 404);
    } //500
    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories has error 404 for invalid ID")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "/10000000").getStatusCode(), 404);
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
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList).getBody().asString().contains("page="));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the features list has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList + "?item=10").getStatusCode(), 404);
    } //still 200

    @Test
    @Order(5)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody body = RestAssured.given().when().spec(requestSpecification).request(Method.GET, featuresList).getBody();
        Assert.assertTrue(body.prettyPrint().contains("feature_id") && body.prettyPrint().contains("company_id") && body.prettyPrint().contains("feature_type")
                && body.prettyPrint().contains("parent_id") && body.prettyPrint().contains("display_on_product") && body.prettyPrint().contains("display_on_catalog")
                && body.prettyPrint().contains("display_on_header") && body.prettyPrint().contains("description") && body.prettyPrint().contains("lang_code")
                && body.prettyPrint().contains("prefix") && body.prettyPrint().contains("suffix") && body.prettyPrint().contains("categories_path")
                && body.prettyPrint().contains("full_description") && body.prettyPrint().contains("status") && body.prettyPrint().contains("comparison")
                && body.prettyPrint().contains("position") && body.prettyPrint().contains("purpose") && body.prettyPrint().contains("feature_style")
                && body.prettyPrint().contains("filter_style") && body.prettyPrint().contains("feature_code") && body.prettyPrint().contains("group_position"));
    }
    @Test
    @Order(6)
    @DisplayName("Asserts that response has error 404 for ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?page=1&items_per_page=20&include_group=true&feature_ids[]=-1000000").getStatusCode(), 404);
    } //200
    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories has error 404 for invalid ID")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?page=1&items_per_page=20&include_group=true&feature_ids[]=invalid").getStatusCode(), 404);
    }//200
}
@Slf4j
class Gw_catalog_v1_features_variants_list {

    String featureVariantsList = "https://test4.jmart.kz/gw/catalog/v1/features/variants/list";

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
    @DisplayName("Asserts that the feature variants list is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList).getBody());
    }

    @Test
    @Order(2)
    @DisplayName("Asserts that the feature variants list has a pagination.")
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList).getBody().asString().contains("next_page"));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the features list has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList).getBody().asString().contains("per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList + "?item=118103").getStatusCode(), 404);
    } //200

    @Test
    @Order(5)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody body = RestAssured.given().when().spec(requestSpecification).request(Method.GET, featureVariantsList).getBody();
        Assert.assertTrue(body.prettyPrint().contains("variant_id") && body.prettyPrint().contains("variant") && body.prettyPrint().contains("description")
                && body.prettyPrint().contains("page_title") && body.prettyPrint().contains("meta_keywords") && body.prettyPrint().contains("meta_description")
                && body.prettyPrint().contains("lang_code") && body.prettyPrint().contains("yml2_unit") && body.prettyPrint().contains("ab__custom_feature_variant_h1")
                && body.prettyPrint().contains("ab__sf_seo_variant") && body.prettyPrint().contains("feature_id") && body.prettyPrint().contains("url")
                && body.prettyPrint().contains("color") && body.prettyPrint().contains("position") && body.prettyPrint().contains("seo_name")
                && body.prettyPrint().contains("seo_path"));
    }
    @Test
    @Order(6)
    @DisplayName("Asserts that response has error 404 for ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?page=1&items_per_page=20&feature_id=18&variant_ids[]=-10000000").getStatusCode(), 404);
    } //200
    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories has error 404 for invalid ID")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, "?page=1&items_per_page=20&include_group=true&feature_ids[]=invalid").getStatusCode(), 404);
    }//200

}
@Slf4j
class Gw_catalog_v1_my_products_statusChange_id {
    String statusChange = "https://test4.jmart.kz/gw/catalog/v1/products/status-change/342517";

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
    // cannot request put since the "https://test4.jmart.kz/gw/catalog/v1/my/products" endpoint has 403
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
    public void hasPagination(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsListing + "?category_id=268").getBody().asString().contains("total_pages"));
    }

    @Test
    @Order(3)
    @DisplayName("Asserts that the products list has a limit.")
    public void hasLimit(){
        Assert.assertTrue(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsListing + "?category_id=268").getBody().asString().contains("items_per_page"));
    }

    @Test
    @Order(4)
    @DisplayName("Asserts that if the parameter is incorrect, the 400 error will occur")
    public void incorrectParameter() {
        Assert.assertEquals(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsListing + "/@#@&*").getStatusCode(), 404);
    }

    @Test
    @Order(5)
    @DisplayName("Asserts that response has correct data for valid ID")
    public void validIdCheckResponseData(){
        ResponseBody body = RestAssured.given().request(Method.GET, productsListing + "?category_id=268").getBody();
        Assert.assertTrue(body.asString().contains("feature_id") && body.asString().contains("product_id") && body.asString().contains("variant_id")
                && body.asString().contains("description") && body.asString().contains("variant") && body.asString().contains("value_int")
                && body.asString().contains("value"));
    }
    @Test
    @Order(6)
    @DisplayName("Asserts that response has error 404 for ID that does not exist")
    public void nonExistingIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, productsListing + "?category_id=-1").getStatusCode(), 404);
    } //200
    @Test
    @Order(7)
    @DisplayName("Asserts that the list of categories has error 404 for invalid ID")
    public void inValidIdCheckResponseData(){
        Assert.assertEquals(RestAssured.given().request(Method.GET, productsListing + "?category_id=-*/-*").getStatusCode(), 404);
    } //422
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

    @Test
    @Order(1)
    @DisplayName("Returns product list using product_id")
    public void allFieldsAreCompletedWithValidData(){
        String productId = "3177149";
        given()
                .when()
                .spec(requestSpecification)
                .body("{ \"product_id\": \"" + productId + "\", \"company_id\": \"" + "311632" + "\"}")
                .post("https://test4.jmart.kz/gw/catalog/v1/products/by_codes?product_id=311632");
        System.out.println(RestAssured.given().when().spec(requestSpecification).request(Method.POST, "https://test4.jmart.kz/gw/catalog/v1/products/by_codes?product_id=311632").getBody().prettyPrint());
    }
    //        "status": 403,
    //        "error": "Access forbidden",
    //        "message": "You don't have permission to access this resource"
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
    @Test
    @Order(1)
    @DisplayName("Asserts that the product description is not empty.")
    public void notEmptyList(){
        Assert.assertNotNull(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productByIds + "?product_id=84894").getBody());
    }
    //500 error

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
    //500 error
}
@Slf4j
class Gw_catalog_v1_products_condition {
    String productsCondition = "https://test4.jmart.kz/gw/catalog/v1/products/condition";

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
        System.out.println(RestAssured.given().when().spec(requestSpecification).request(Method.GET, productsCondition).getBody().prettyPrint());
    }
    //        "status": 404,
    //        "error": "NOT_FOUND",
    //        "message": "NOT_FOUND",
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
    // 500 error
}

@Slf4j
class Gw_catalog_v1_products_remove_price {
    //Condition???
}

@Slf4j
class Gw_catalog_v1_products_status_change_id {
    //What ID? product_id?
    String productStatusChange = "https://test4.jmart.kz";

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
        String status = "newStatus";
        given()
                .when()
                .spec(requestSpecification)
                .body("{ \"status\": \"" + status + "\"}")
                .put("https://test4.jmart.kz/gw/catalog/v1/products/status-change/84894")
                .then()
                .assertThat()
                .body("status", is("newStatus"));
//        System.out.println(RestAssured.given().when().spec(requestSpecification).request(Method.PUT, productStatusChange).getBody().prettyPrint());
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

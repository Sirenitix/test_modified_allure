package com.example.catalog_service_api_tests;

import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

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
        System.out.println(responseBody.prettyPrint());
        Assert.assertNotNull(responseBody);
    }

    @Test
    @Order(6)
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


}
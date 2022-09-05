package com.example.catalog_service_api_tests;

import io.restassured.http.Headers;
import io.restassured.response.ResponseBody;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

class catalog {

    @Test
    public void catalog_v1_categories_by_ids(){
        RestAssured.baseURI = "https://test4.jmart.kz/catalog/v1/categories/by_ids";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.request(Method.GET, "");
        ResponseBody body = response.getBody();
        Assert.assertNotNull(body.asString(), "Result: Response is not empty");
    }
}

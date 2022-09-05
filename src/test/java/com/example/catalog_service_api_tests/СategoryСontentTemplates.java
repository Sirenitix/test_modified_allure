package com.example.catalog_service_api_tests;


import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;

public class СategoryСontentTemplates {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI="https://test4.jmart.kz/";
    }
    @Test
    @Order(1)
    @DisplayName("Get token")
    public void getToken(){
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("login", "dev_test_admin@email.com");
        request.put("password", "Test_4dmin_Jmart");
        ResponseBody responseBody = requestSpecification.given().body(request).post("user/v1/auth/sign-in");
    }

}

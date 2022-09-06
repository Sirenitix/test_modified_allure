package com.example.catalog_service_api_tests;


import com.example.catalog_service_api_tests.entity.Credentials;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
public class СategoryСontentTemplates {


    @Autowired
    Credentials credentials;


    @BeforeAll
    public static void setup(){
        RestAssured.baseURI="https://test4.jmart.kz";

    }


    public String getToken(){
        RequestSpecification requestSpecification = RestAssured.given();
        Map<String, String> map = new HashMap<>();
        map.put("login", credentials.getLogin());
        map.put("password", credentials.getPassword());
        JSONObject credentials = new JSONObject(map);
        ValidatableResponse response = requestSpecification.given().contentType("application/json").body(credentials.toJSONString()).post("/user/v1/auth/sign-in").then();
        String token = response.extract().jsonPath().get("data.tokens.auth.token").toString();
        return token;
    }

    @Test
    @DisplayName("Feature Handbook Api Test")
    public void featureHandbook(){
        RequestSpecification requestSpecification = RestAssured.given();
        String token = getToken();
        ResponseBody<Response> response = requestSpecification.given().header("Authorization", "Bearer "+ token).contentType("application/json").get("/gw/catalog/v1/category-content-templates-features-handbook");
        log.info(response.asString() + " - response");
    }

}

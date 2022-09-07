package com.example.catalog_service_api_tests;

import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static io.restassured.RestAssured.given;

@Slf4j
@SpringBootTest
public abstract class AbstractTest  {

    @Autowired
    private Configurations configurations;

    protected RequestSpecification requestSpecification;

    final String WRONG_DATA = "@#@&*";

    final Integer ZERO = 0;

    final Integer ONE = 1;

    final Long RIGHT_PAGE_NUMBER = 7L;

    final Long WRONG_PAGE_NUMBER = 909090909L;

    final Long NEGATIVE_PAGE_NUMBER = -909090909L;

    final String TEST_TEMPLATE_FEATURE_NAME = String.valueOf(new Random().nextInt());

    final String TEST_TEMPLATE_FEATURES = String.valueOf(new Random().nextInt());

    // variable for creating new template(post)
    // p.s. endpoint: /gw/catalog/v1/category-content-templates-features-handbook
    final String TEST_TEMPLATE = "{\n" +
            "  \"template_feature_name\": \"" + TEST_TEMPLATE_FEATURE_NAME + "\",\n" +
            "  \"features\":[ \"" + TEST_TEMPLATE_FEATURES + "\"]\n" +
            "}";

   final String TESTTEMPLATE_ONLY_WITH_NAME =  "{\n" +
                    "  \"template_feature_name\": \"" + TEST_TEMPLATE_FEATURE_NAME + "\" \n" +
                    "}";

    final String TESTTEMPLATE_WITH_WRONG_NAME =  "{\n" +
            "  \"template_feature_name\":  909090909  \n" +
            "}";
    final String TESTTEMPLATE_ONLY_WITH_FEATURES = "{\n" +
                    "  \"features\":[ \"" + TEST_TEMPLATE_FEATURES + "\"]\n" +
                    "}";

    final String TESTTEMPLATE_WITH_WRONG_FEATURES = "{\n" +
            "  \"template_feature_name\": \"" + TEST_TEMPLATE_FEATURE_NAME + "\",\n" +
            "  \"features\":[  909090909  ]\n" +
            "}";

    //

    final String EMPTY_JSON = "{}";


    @BeforeEach
    protected void setup(){
        RestAssured.baseURI = configurations.getBaseUri();
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
}

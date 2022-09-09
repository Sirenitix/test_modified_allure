package com.example.catalog_service_api_tests;

import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static com.example.catalog_service_api_tests.ConstsTeamplateFeature.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Slf4j
@SpringBootTest
public abstract class AbstractConfiguration    {

    RequestSpecification requestSpecification;

    @Autowired
    private Configurations configurations;

    public Response getFeatureHandbook(){
        return  given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath());

    }

    public Response getFeatureHandbookWithLimit(String limit){
        return given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithLimitPath() + limit);

    }

    public Response getFeatureHandbookWithOffset(String offset) {
       return given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithOffsetPath() + offset);
    }

    public Response getFeatureHandbookById(String id) {
            return given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath() + id);
    }

    public RequestSpecification specification(){
       return given().log().all()
                .when()
                .spec(requestSpecification);
    }


    public JsonPath createRandomEntity(){
        JsonPath response =  given().log().all()
                .when()
                .spec(requestSpecification)
                .body(TEST_TEMPLATE)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .extract()
                .response()
                .getBody()
                .jsonPath();

        return response;
    }

    public Response createEntity(String featureName, String features){

        return given().log().all()
                .when()
                .spec(requestSpecification)
                .body("{\n" +
                        "  \"template_feature_name\": \"" + featureName + "\",\n" +
                        "  \"features\":[ \"" + features + "\"]\n" +
                        "}")
                .post(configurations.getFeatureHandbookPath())
                .then()
                .extract()
                .response();
    }


    public Response deleteById(String entityId){

        return given().log().all()
                .when()
                .spec(requestSpecification)
                .delete(configurations.getFeatureHandbookPath() + entityId)
                .then()
                .extract()
                .response();

    }


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

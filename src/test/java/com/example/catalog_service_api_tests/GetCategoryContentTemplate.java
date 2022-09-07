package com.example.catalog_service_api_tests;


import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static io.restassured.RestAssured.given;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.linesOf;
import static org.hamcrest.Matchers.*;



@Slf4j
public class GetCategoryContentTemplate extends AbstractTest {

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("check feature handbook's status code and status value")
    public void featureHandbook(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("success", is(Boolean.TRUE));
    }


    @Test
    @Order(1)
    @DisplayName("request with wrong parameter should return 422")
    public void notEmptyList(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithParamPath() + WRONG_DATA)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    @Test
    @Order(2)
    @DisplayName("check for existence of pagination")
    public void thereIsAPagination(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .body("data.pagination.page" , is(instanceOf(Integer.class)))
                .body("data.pagination.items_per_page" , is(instanceOf(Integer.class)));;
    }



    @Test
    @Order(3)
    @DisplayName("check for right limit")
    public void rightALimit(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithLimitPath() + RIGHT_PAGE_NUMBER)
                .then()
                .body("data.params.items_per_page" , is(RIGHT_PAGE_NUMBER));
    }


    @Test
    @Order(4)
    @DisplayName("then the item not exist")
    public void notFound(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithLimitPath() + WRONG_DATA)
                .then()
                .assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    @Order(5)
    @DisplayName("checking for sorting order")
    public void isSorted(){
       Response response = given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath())
                .then()
                .extract()
                .response();

       List<Long> data = response
               .getBody()
               .jsonPath()
               .getList("data.data.id");

       List<Long> sortedData = new ArrayList<>(data);
       sortedData.sort(Comparator.naturalOrder());

       assertThat(data).isEqualTo(sortedData);

    }

    @Test
    @Order(6)
    @DisplayName("check for emptiness of list when param is wrong")
    public void emptyListThenOffsetIsWrong(){
        Response response = given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithOffsetPath() + WRONG_PAGE_NUMBER)
                .then()
                .extract()
                .response();

        List<Long> data = response
                .getBody()
                .jsonPath()
                .getList("data.data.id");

        assertThat(data.size()).isEqualTo(ZERO);
    }


    @Test
    @Order(7)
    @DisplayName("return first page when offset is negative")
    public void fromFirstWhenOffsetIsNegative(){
        Response response = given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithOffsetPath() + WRONG_PAGE_NUMBER)
                .then()
                .extract()
                .response();

        List<Long> data = response
                .getBody()
                .jsonPath()
                .getList("data.data.id");

        assertThat(data.size()).isEqualTo(ZERO);
    }

    @Test
    @Order(8)
    @DisplayName("request with wrong offset should return 422")
    public void offsetParamWrong(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithOffsetPath() + WRONG_DATA)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    @Test
    @Order(9)
    @DisplayName("request with wrong limit should return 422")
    public void limitParamWrong(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithLimitPath() + WRONG_DATA)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }


    @Test
    @Order(10)
    @DisplayName("return first page when page number is negative")
    public void negativeOffset(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookWithOffsetPath() + NEGATIVE_PAGE_NUMBER)
                .then()
                .body("data.pagination.page" , is(ONE));
    }



}



@Slf4j
@Nested
class GetByIdCategoryContentTemplate extends AbstractTest {

    @Autowired
    private Configurations configurations;


    @Test
    @Order(0)
    @DisplayName("get by right id checking for correctness")
    public void dataCheck(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .body("success" , is(Boolean.TRUE))
                .body("data.id", is(ONE));
    }

    @Test
    @Order(1)
    @DisplayName("return 422 if id is incorrect")
    public void invalidId(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath() + WRONG_DATA)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    @Test
    @Order(2)
    @DisplayName("return 404 if id is not exist")
    public void notExist(){
        given()
                .when()
                .spec(requestSpecification)
                .get(configurations.getFeatureHandbookPath() + WRONG_PAGE_NUMBER)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

}



@Slf4j
@Nested
class PostCategoryContentTemplate extends AbstractTest {

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("create template with name and features check for name and features")
    public void create(){
        given().log().all()
                .when()
                .spec(requestSpecification)
                .body(TEST_TEMPLATE)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .body("data.template_feature_name", is(TEST_TEMPLATE_FEATURE_NAME))
                .body("data.features[0]", is(TEST_TEMPLATE_FEATURES));

    }

    @Test
    @Order(1)
    @DisplayName("create template only with name check for status")
    public void onlyName(){
        given().log().all()
                .when()
                .spec(requestSpecification)
                .body(TESTTEMPLATE_ONLY_WITH_NAME)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(2)
    @DisplayName("create template only with name check for status")
    public void onlyFeatures(){
        given().log().all()
                .when()
                .spec(requestSpecification)
                .body(TESTTEMPLATE_ONLY_WITH_FEATURES)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }


    @Test
    @Order(3)
    @DisplayName("create template with wrong name check for status")
    public void wrongBodyParamName(){
        given().log().all()
                .when()
                .spec(requestSpecification)
                .body(TESTTEMPLATE_WITH_WRONG_NAME)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(4)
    @DisplayName("create template with integer features check for status 422")
    public void wrongBodyParamFeatures(){
        given().log().all()
                .when()
                .spec(requestSpecification)
                .body(TESTTEMPLATE_WITH_WRONG_FEATURES)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(5)
    @DisplayName("create template with integer features check for status 422")
    public void withoutAnyParameter(){
        given().log().all()
                .when()
                .spec(requestSpecification)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(6)
    @DisplayName("create template with integer features check for status 422")
    public void emptyJson(){
        given().log().all()
                .when()
                .spec(requestSpecification)
                .body(EMPTY_JSON)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }



}



package com.example.catalog_service_api_tests;


import com.example.catalog_service_api_tests.entity.Configurations;
import io.restassured.path.json.JsonPath;
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
public class GetCategoryContentTemplate extends AbstractConfiguration implements ConstsTeamplateFeature {

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("check feature handbook's status code and status value")
    public void featureHandbook(){
        getFeatureHandbook()
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
        getFeatureHandbook()
                .then()
                .body("data.pagination.page" , is(instanceOf(Integer.class)))
                .body("data.pagination.items_per_page" , is(instanceOf(Integer.class)));;
    }



    @Test
    @Order(3)
    @DisplayName("check for right limit")
    public void rightALimit(){
       getFeatureHandbookWithLimit(String.valueOf(RIGHT_NUMBER))
                .then()
                .body("data.params.items_per_page" , is(RIGHT_NUMBER));
    }


    @Test
    @Order(4)
    @DisplayName("then the item not exist")
    public void notFound(){
        getFeatureHandbookWithLimit(WRONG_DATA)
                .then()
                .assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    @Order(5)
    @DisplayName("checking for sorting order")
    public void isSorted(){
       Response response = getFeatureHandbook()
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
        Response response = getFeatureHandbookWithOffset(WRONG_NUMBER)
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
        Response response = getFeatureHandbookWithOffset(WRONG_NUMBER)
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
        getFeatureHandbookWithOffset(WRONG_DATA)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    @Test
    @Order(9)
    @DisplayName("request with wrong limit should return 422")
    public void limitParamWrong(){
        getFeatureHandbookWithLimit(WRONG_DATA)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }


    @Test
    @Order(10)
    @DisplayName("return first page when page number is negative")
    public void negativeOffset(){
        getFeatureHandbookWithOffset(NEGATIVE_NUMBER)
                .then()
                .body("data.pagination.page" , is(ONE));
    }



}



@Slf4j
@Nested
class GetByIdCategoryContentTemplate extends AbstractConfiguration implements ConstsTeamplateFeature {

    @Autowired
    private Configurations configurations;


    @Test
    @Order(0)
    @DisplayName("get by right id checking for correctness")
    public void dataCheck(){
        getFeatureHandbookById(ONE)
                .then()
                .body("success" , is(Boolean.TRUE))
                .body("data.id", is(ONE));
    }

    @Test
    @Order(1)
    @DisplayName("return 422 if id is incorrect")
    public void invalidId(){
        getFeatureHandbookById(WRONG_DATA)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    @Test
    @Order(2)
    @DisplayName("return 404 if id is not exist")
    public void notExist(){
        getFeatureHandbookById(WRONG_NUMBER)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

}



@Slf4j
@Nested
class PostCategoryContentTemplate extends AbstractConfiguration implements ConstsTeamplateFeature {

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("create template with name and features check for name and features")
    public void create(){
        specification()
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
        specification()
                .body(TEST_TEMPLATE_ONLY_WITH_NAME)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(2)
    @DisplayName("create template only with name check for status")
    public void onlyFeatures(){
        specification()
                .body(TEST_TEMPLATE_ONLY_WITH_FEATURES)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }


    @Test
    @Order(3)
    @DisplayName("create template with wrong name check for status")
    public void wrongBodyParamName(){
        specification()
                .body(TEST_TEMPLATE_WITH_WRONG_NAME)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(4)
    @DisplayName("create template with integer features check for status 422")
    public void wrongBodyParamFeatures(){
        specification()
                .body(TEST_TEMPLATE_WITH_WRONG_FEATURES)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(5)
    @DisplayName("create template with integer features check for status 422")
    public void withoutAnyParameter(){
        specification()
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(6)
    @DisplayName("create template with integer features check for status 422")
    public void emptyJson(){
        specification()
                .body(EMPTY_JSON)
                .post(configurations.getFeatureHandbookPath())
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }



}


@Slf4j
@Nested
class PutCategoryContentTemplate extends AbstractConfiguration implements ConstsTeamplateFeature {

    @Autowired
    private Configurations configurations;

    @Test
    @Order(0)
    @DisplayName("update template with name and features check for name and features")
    public void update(){
        specification()
                .body(TEST_TEMPLATE)
                .put(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .body("data.template_feature_name", is(TEST_TEMPLATE_FEATURE_NAME))
                .body("data.features[0]", is(TEST_TEMPLATE_FEATURES));

    }

    @Test
    @Order(1)
    @DisplayName("update template only with name check for status")
    public void updateOnlyName(){
        specification()
                .body(TEST_TEMPLATE_ONLY_WITH_NAME)
                .put(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(2)
    @DisplayName("update template only with name check for status")
    public void updateOnlyFeatures(){
        specification()
                .body(TEST_TEMPLATE_ONLY_WITH_FEATURES)
                .put(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }


    @Test
    @Order(3)
    @DisplayName("update template with wrong name check for status")
    public void wrongBodyParamName(){
        specification()
                .body(TEST_TEMPLATE_WITH_WRONG_NAME)
                .put(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(4)
    @DisplayName("update template with integer features check for status 422")
    public void wrongBodyParamFeatures(){
        specification()
                .body(TEST_TEMPLATE_WITH_WRONG_FEATURES)
                .put(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(5)
    @DisplayName("update template with integer features check for status 422")
    public void withoutAnyParameter(){
        specification()
                .put(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }

    @Test
    @Order(6)
    @DisplayName("update template with integer features check for status 422")
    public void emptyJson(){
        specification()
                .body(EMPTY_JSON)
                .put(configurations.getFeatureHandbookPath() + ONE)
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);

    }




}

@Slf4j
@Nested
class DeleteCategoryContentTemplate extends AbstractConfiguration implements ConstsTeamplateFeature {


    @Test
    @Order(0)
    @DisplayName("delete existing object")
    public void delete(){

        String entityIdForDeletion = String.valueOf(createRandomEntity().getInt("data.id"));

        deleteById(entityIdForDeletion)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("success", is(Boolean.TRUE))
                .body("data", is(hasSize(0)));;

    }


    @Test
    @Order(1)
    @DisplayName("delete existing object second time")
    public void deleteAlreadyDeleted(){

        String entityIdForDeletion = String.valueOf(
                createRandomEntity().getInt("data.id"));
        Response responseAfterFirstDeletion = deleteById(entityIdForDeletion);

        responseAfterFirstDeletion.then().statusCode(HttpStatus.SC_OK)
                .body("success", is(Boolean.TRUE))
                .body("data", is(hasSize(0)));

        Response responseAfterSecondDeletion = deleteById(entityIdForDeletion);

        responseAfterSecondDeletion.then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }


    @Test
    @Order(2)
    @DisplayName("delete not existing object")
    public void deleteByIdThatNotExist(){

        deleteById(WRONG_NUMBER).then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    @Order(3)
    @DisplayName("delete not existing object")
    public void deleteByInvalidId(){

        deleteById(WRONG_NUMBER).then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }


    @Test
    @Order(4)
    @DisplayName("delete existing object and add again")
    public void deleteByIdAndCreateSameObject(){

        JsonPath entityForDeletion = createRandomEntity();
        deleteById(String.valueOf(entityForDeletion.getInt("data.id")));
        String featureName = entityForDeletion.getString("data.template_feature_name");
        String features = (String) entityForDeletion.getList("data.features").get(0);
        Integer id = entityForDeletion.getInt("data.id");
        Response recreateEntity = createEntity(featureName, features);
        recreateEntity
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("success", is(Boolean.TRUE))
                .body("data.template_feature_name", is(featureName))
                .body("data.features[0]", is(features))
                .body("data.id", is(not(id)));

    }




}
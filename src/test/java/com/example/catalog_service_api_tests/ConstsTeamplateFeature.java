package com.example.catalog_service_api_tests;

import java.util.Random;

public interface ConstsTeamplateFeature {
     String WRONG_DATA = "@#@&*";

     Integer ZERO = 0;

     String ONE = String.valueOf(1);

     Long RIGHT_NUMBER = 7L;

     String WRONG_NUMBER = String.valueOf(909090909L);

     String NEGATIVE_NUMBER = String.valueOf(-909090909L);

     String TEST_TEMPLATE_FEATURE_NAME = String.valueOf(new Random().nextInt());

     String TEST_TEMPLATE_FEATURES = String.valueOf(new Random().nextInt());

     String TEST_TEMPLATE = "{\n" +
            "  \"template_feature_name\": \"" + TEST_TEMPLATE_FEATURE_NAME + "\",\n" +
            "  \"features\":[ \"" + TEST_TEMPLATE_FEATURES + "\"]\n" +
            "}";

     String TEST_TEMPLATE_ONLY_WITH_NAME =  "{\n" +
            "  \"template_feature_name\": \"" + TEST_TEMPLATE_FEATURE_NAME + "\" \n" +
            "}";

     String TEST_TEMPLATE_WITH_WRONG_NAME =  "{\n" +
            "  \"template_feature_name\":  909090909  \n" +
            "}";
     String TEST_TEMPLATE_ONLY_WITH_FEATURES = "{\n" +
            "  \"features\":[ \"" + TEST_TEMPLATE_FEATURES + "\"]\n" +
            "}";

     String TEST_TEMPLATE_WITH_WRONG_FEATURES = "{\n" +
            "  \"template_feature_name\": \"" + TEST_TEMPLATE_FEATURE_NAME + "\",\n" +
            "  \"features\":[  909090909  ]\n" +
            "}";

     String EMPTY_JSON = "{}";


}

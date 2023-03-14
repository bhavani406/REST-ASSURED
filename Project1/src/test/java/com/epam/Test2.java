package com.epam;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class Test2 {
    String url = "https://jsonplaceholder.typicode.com";
    private static final ResponseSpecification responseSpecification = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType("application/json").build();

    //1. Verify the number of resources at each resource end point
    @Test
    public static void numberOfResources() throws IOException {
        String[] resources = {"posts", "comments", "albums", "photos", "todos", "users"};

        for (String resource : resources) {
            Response response = get("https://jsonplaceholder.typicode.com/" + resource);
            List resourceCount = response.path("id");
            System.out.println("Total number of " + resource + ": " + resourceCount.size());
            response.then().spec(responseSpecification);

        }
    }
}




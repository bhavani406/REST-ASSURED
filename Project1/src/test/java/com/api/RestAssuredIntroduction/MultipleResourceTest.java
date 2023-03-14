package com.api.RestAssuredIntroduction;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.model.Post;

import static io.restassured.RestAssured.*;

public class MultipleResourceTest {
    static String url = "https://jsonplaceholder.typicode.com/posts";

    private static final ResponseSpecification responseSpecification = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType("application/json").build();

    //1. Verify the number of resources at each resource end point
    @Test
    public static void numberOfResources() throws IOException {
        String[] resources = {"posts", "comments", "albums", "photos", "todos", "users"};

        for (String resource : resources) {
            Response response = get("https://jsonplaceholder.typicode.com/"+resource);
            List<String> resourceCount = response.path("id");
            System.out.println("Total number of " + resource + ": " + resourceCount.size());
            response.then().spec(responseSpecification);
        }
    }


    /*@Test
    public static void postRequest() throws IOException {
        Map<String, Object> postsMap = new HashMap<>();
        postsMap.put("userId",1);
        postsMap.put("id",11);
        postsMap.put("title","sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        postsMap.put("body", "TEST_BODY");

        int postsId = 101;

        Response response = given().body(postsMap).when().post("https://jsonplaceholder.typicode.com/posts/"+postsId);

       *//* List data = response.jsonPath().get();
        response.getBody().as(ArrayList.class);
        System.out.println(data);*//*
        response.then().spec(responseSpecification);
    }*/
    @Test
    public static void getOneResourceRequest() throws IOException {
        Response response = get("https://jsonplaceholder.typicode.com/posts/1");
        Post post = response.getBody().as(Post.class); //deserialization
        System.out.println(post);
        response.then().spec(responseSpecification);
        int responsecode = response.getStatusCode();
        Assert.assertEquals(responsecode, 200);
        String contentType = response.contentType();
        System.out.println(contentType);
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
        int Id = response.path("id");
        Assert.assertEquals(Id, 1);

    }



}





package com.api.RestAssuredIntroduction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.model.Post;

import static io.restassured.RestAssured.*;

public class GetRequestTest {
    @BeforeClass
    public void setUp() {
        RestAssured.responseSpecification=new ResponseSpecBuilder().build();
    }
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

    @Test
    public static void getRequest() throws IOException {
        String[] resources = {"posts", "comments", "albums", "photos", "todos", "users"};

        for (String resource : resources) {
            Response response = get("https://jsonplaceholder.typicode.com/" + resource);
            List data = response.jsonPath().get();
            response.getBody().as(ArrayList.class);
            System.out.println(data);
            response.then().spec(responseSpecification).statusCode(200).contentType("application/json");

            /*ObjectMapper mapper = new ObjectMapper();
            List result = response.jsonPath().get();

            for(int i=0; i< result.size(); i++) {
                Post p = mapper.convertValue(result.get(i), Post.class);
                System.out.println(p);
                response.then().spec(responseSpecification);
            }*/

        }
    }
}



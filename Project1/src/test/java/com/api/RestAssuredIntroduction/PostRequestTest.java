package com.api.RestAssuredIntroduction;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.api.model.Post;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRequestTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/";
        RestAssured.basePath = "/posts";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType("application/json").build();
    }

    @Test(dataProvider = "postPayloadData")
    public void createPost(int id, int userId, String title, String body) throws IOException {

        Post post = new Post(userId, id, title, body);

        /*ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/post.json"), post); //serialization java object to json object
        String postString = objectMapper.writeValueAsString(post);// json object to json string
        System.out.println(postString);

        Post postObject = objectMapper.readValue(new File("target/post.json"), Post.class);*/// deserialization json object to java object
        Response response = given().contentType(ContentType.JSON).body(post).when().post();
        response.then().assertThat().statusCode(201).contentType("application/json");
        int postId = response.path("id");
        String poststring= post.toString();
        System.out.println(post);
        System.out.println("New post id created " + postId);

    }

    @DataProvider(name = "postPayloadData")
    public Object[][] getPostPayloadData() {
        return new Object[][]{{11, 101, "test_title", "test_post_body"}};
    }
}



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

import static io.restassured.RestAssured.*;

public class PutRequestTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/";
        RestAssured.basePath = "/posts";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType("application/json").build();
    }

    @Test(dataProvider = "postPayloadData")
    public void createPut(int id, int userId, String title, String body) throws IOException {

        Post post = new Post(userId, id, title, body);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/put.json"), post); //serialization java object to json object
        String putString = objectMapper.writeValueAsString(post);// json object to json string
        System.out.println(putString);

        Post postObject = objectMapper.readValue(new File("target/post.json"), Post.class);// deserialization json object to java object
        Response response = given().contentType(ContentType.JSON).body(postObject).when().put();
        response.then().assertThat().statusCode(201).contentType("application/json");
        int putId = response.path("id");
        String putString1= postObject.toString();
        System.out.println(putString1);
        System.out.println("New put id created " + putId);

    }

    @DataProvider(name = "postPayloadData")
    public Object[][] getPostPayloadData() {
        return new Object[][]{{11, 101, "test_title", "test_put_body"}};
            }
}



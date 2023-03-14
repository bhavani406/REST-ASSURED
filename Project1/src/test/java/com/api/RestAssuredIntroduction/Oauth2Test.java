package com.api.RestAssuredIntroduction;

import com.api.model.Gorest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.model.Post;

import static io.restassured.RestAssured.*;

public class Oauth2Test {
    String accesstoken= "df19f6645506a841670fadc78987a219d58dc3564056f91b5054416eec8e83d0";
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://gorest.co.in/public";
        RestAssured.basePath = "/v2/users";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType("application/json").build();
    }
    @Test(dataProvider = "payloadData")
    public void goRestTest(int id,String name,String email,String gender,String status){
        Gorest gorest=new Gorest(id,name,email,gender,status);
Response response=given().auth().oauth2(accesstoken)
        .body(gorest).when().post();
       response.then().assertThat().statusCode(201).contentType("application/json");
    }
    @DataProvider(name = "payloadData")
    public Object[][] payloadData() {
        return new Object[][]{{1001702, "yami", "yami@sanford.com", "female","active"}};
    }
}

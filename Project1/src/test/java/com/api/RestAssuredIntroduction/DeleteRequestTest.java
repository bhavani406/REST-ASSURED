package com.api.RestAssuredIntroduction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.api.model.Post;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteRequestTest {
    @BeforeClass
    public void setUp() {
        baseURI = "https://petstore.swagger.io";
        basePath = "/v2/pet/";

        responseSpecification = new ResponseSpecBuilder().
                expectContentType("application/json").build();

    }
    @Test
    public void deletePet(){
        int petId=1234;
        Response response=given().delete(baseURI+basePath+petId);
        response.then().spec(responseSpecification);
        Assert.assertEquals(200,response.statusCode());

    }


}

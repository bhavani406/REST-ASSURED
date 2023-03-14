package com.api.RestAssuredIntroduction;

import com.api.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetStoreTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2/pet";

        RestAssured.requestSpecification= new RequestSpecBuilder().
                setContentType("application/json").build();

    }

    @Test(dataProvider = "petPayloadData")
    public void createPet(int petId, Category category, String petName, List<String> photoURLs, List<Tags> tags, String status) throws IOException {

        Pet pet = new Pet(petId, category, petName, photoURLs, tags, status);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/pets.json"), pet);
        String petString = objectMapper.writeValueAsString(pet);
        System.out.println(petString);

        Pet petData = objectMapper.readValue(new File("target/pets.json"), Pet.class);
        Response response = given().contentType(ContentType.JSON).body(petData).when().post();
    }
        @Test
        public void getRequest(){
            Response response1 = get("https://petstore.swagger.io/v2/pet/12345");
            response1.then().assertThat().statusCode(200).contentType("application/json");
            GetPet get = response1.getBody().as(GetPet.class);
            int petid= get.getId();
            Assert.assertEquals(petid,12345);
            String name=get.getName();
            Assert.assertEquals(name,"snoopie");
            String status=get.getStatus();
            Assert.assertEquals(status,"pending");
        }

        /*response.then().assertThat().statusCode(200).contentType("application/json");
        int petid = response.path("id");
        System.out.println("New pet id created " +petid);
        String petcategory =response.path("category.name");
        System.out.println("That if the pet is a ‘dog’ :" +petcategory);
        String name= response.path("name");
        System.out.println("That its name is ‘snoopie’:" +name);
        String statuss= response.path("status");
        System.out.println("That its current status is ‘pending’:" +statuss);
        Assert.assertEquals("pending",statuss);
*/


    @DataProvider(name = "petPayloadData")
    public Object[][] getPetPayloadData() {
        Category category = new Category(1,"dog");
        Tags tags = new Tags(0,"string");
        List<Tags> tagList = new ArrayList<>();
        tagList.add(tags);

        return new Object[][] {
                {12345, category, "snoopie", Arrays.asList("api", "testing","funda") , tagList, "pending"}
        };
    }
}


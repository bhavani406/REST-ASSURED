package com.api.RestAssuredIntroduction;
import io.restassured.RestAssured;
import io.restassured.response.Response;
/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;*/
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delete {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";
    }

    @Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("1234")
                .then()
                .extract().response();

      Assert.assertEquals(200, response.statusCode());
    }
}
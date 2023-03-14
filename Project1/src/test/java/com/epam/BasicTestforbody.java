package com.epam;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class BasicTestforbody {
    @Test
    public void verifyStatusCOde() {
        given().baseUri("http://api.zippopotam.us/").
        when().get("us/90210").
         then().
                assertThat().statusCode(200).contentType(equalTo("application/json")).
                body("'post code'",equalTo("90210")).
                body("country",equalTo("United States")).
                body("places[0].'place name'",equalTo("Beverly Hills"));
    }


    @Test
    public void verifyNegativeScenario() {
        given().
                baseUri("https://api.zippopotam.us").
                when().
                get("/US/9020").
                then().
                assertThat().statusCode(404);
    }



}




package com.epam;


import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class Basictestforstatuscode{
   @Test
   public void verifyStatusCOde() {
       given().baseUri("http://api.zippopotam.us/").
               when().get("us/90210").
               then().assertThat().statusCode(200);
   }
   @Test
       public void verifyCode() throws IOException {
           URL restEndpoint=new URL("http://api.zippopotam.us/us/90210");
           HttpURLConnection httpURLConnection= (HttpURLConnection) restEndpoint.openConnection();
           httpURLConnection.setRequestMethod("GET");
           int responsecode= httpURLConnection.getResponseCode();
           Assert.assertEquals(responsecode,200);

       }

}


package com.cydeo.tests.day01_practice;

import com.cydeo.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


public class PracticeOne {


    @Test
    public void practiceOneGoogle(){

        Response response = get(ConfigurationReader.getProperty("google.url"));

        System.out.println(response.statusCode());

        Assertions.assertEquals(200,response.statusCode());

        System.out.println(response.getHeader("Date"));

        Assertions.assertTrue(response.getHeaders().hasHeaderWithName("Date"));

        System.out.println(response.getHeader("Expires"));

        //verify that there is a header named verify
        Assertions.assertTrue(response.getHeaders().hasHeaderWithName("Expires"));



    }

    @Test
    public void practiceTwoYoutube(){

        Response response = get(ConfigurationReader.getProperty("youtube.url"));
        System.out.println(response.statusCode());

        //verify the status code is 200
        Assertions.assertEquals(200,response.statusCode());

        System.out.println(response.getHeader("Pragma"));

        Assertions.assertTrue(response.getHeaders().hasHeaderWithName("Pragma"));

        Assertions.assertEquals("no-cache",response.getHeader("Pragma"));

        int headersCount = response.getHeaders().size();

        System.out.println(headersCount);

        Assertions.assertEquals(20,response.getHeaders().size());
        //

    }
}

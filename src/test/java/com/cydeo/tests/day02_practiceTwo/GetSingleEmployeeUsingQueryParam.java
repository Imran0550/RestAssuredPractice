package com.cydeo.tests.day02_practiceTwo;

import com.cydeo.tests.ORDSTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class GetSingleEmployeeUsingQueryParam extends ORDSTestBase {

    @Test
    public void singleEmployeeUsingQueryParamTest(){

        Map<String ,String> country = new HashMap<>();
        country.put("q","{\"country_name\":\"Argentina\"}");

        Response response = given().accept(ContentType.JSON)
                           .and().queryParams(country).when().get("/countries");
        System.out.println(response.statusCode());
        assertEquals(200,response.statusCode());

        //convert to jsonPath
        JsonPath json = response.jsonPath();

        json.prettyPrint();

        String countryId = json.getString("items.country_id");
        System.out.println("AR id = "+countryId);

    }
}

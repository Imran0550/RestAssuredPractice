package com.cydeo.tests.day02_practiceTwo;

import com.cydeo.tests.ORDSTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
public class GetAllCountriesName extends ORDSTestBase {

    @Test
    public void getAllCountriesNamesTest(){

        Response response = given().accept(ContentType.JSON)
                            .and().get("/countries");
        System.out.println(response.statusCode());

        //convert to jsonPath
        JsonPath json = response.jsonPath();

        //json.prettyPrint();
        List<String> allCountries = json.getList("items.country_name");
        System.out.println("All countries = " + allCountries  +"\n"+ "count = " + allCountries.size());

        System.out.println(allCountries.get(2));

        //add countries that has region_id 2
        List<String> regionTwoCountries = json.getList("items.findAll {it.region_id == 2}.country_name");
        System.out.println("Region 2 countries = " + regionTwoCountries);
        
        //add countries that has region_id 4
        List<String> regionFourCountries = json.getList("items.findAll {it.region_id == 4}.country_name");
        System.out.println("region 4 Countries = " + regionFourCountries);

        //add countries that has region_id 1
        List<String> region1Countries = json.getList("items.findAll {it.region_id == 1}.country_name");
        System.out.println("Region 1 countries = " + region1Countries);

        //add countries that has region_id 3
        List<String> regionThreeCountries = json.getList("items.findAll {it.region_id == 3}.country_name");
        System.out.println("Region 3 countries = " + regionThreeCountries);
    }
}

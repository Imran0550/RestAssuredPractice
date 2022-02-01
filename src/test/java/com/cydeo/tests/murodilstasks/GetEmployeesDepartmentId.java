package com.cydeo.tests.murodilstasks;

import com.cydeo.tests.ORDSTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
public class GetEmployeesDepartmentId extends ORDSTestBase {

    @Test
    public void departmentIdTest(){

        Map<String, String> departmentId = new HashMap<>();
        departmentId.put("q","{\"department_id\":\"80\"}");

        Response response = given().accept(ContentType.JSON)
                .and().queryParams(departmentId).when().get("/employees");
        System.out.println(response.statusCode());
        assertEquals(200,response.statusCode());

        System.out.println("Content type = "+ response.contentType());
        assertEquals("application/json",response.contentType());

               response.prettyPrint();
       // System.out.println("job id = "+response.path("items.job_id"));
        //System.out.println("job id = " + response.path("items.job_id").toString());

        List<String> allJobIds = response.path("items.job_id");
        System.out.println(allJobIds);

        //each job_id starts with SA
        for(String each : allJobIds){
            assertTrue(each.startsWith("SA"));
        }


        List<Integer> allDepartmentIds = response.path("items.department_id");
        System.out.println(allDepartmentIds);

       // verify department id = 80
        for(Integer each : allDepartmentIds){
            assertTrue(each == 80);
        }


       //verify that count = 25
        assertTrue(allDepartmentIds.size() ==25);

    }

    @Test
    public void regionIdTest(){

        Map<String,String> regionId = new HashMap<>();
        regionId.put("q","{\"region_id\" :\"3\"}");
        Response response = given().accept(ContentType.JSON)
                            .and().queryParams(regionId)
                            .when().get("/countries");

        System.out.println(response.statusCode());
        assertEquals(200,response.statusCode());

        //verify content type
        System.out.println("Content type = " + response.contentType());
        assertEquals("application/json",response.contentType());

        List<Integer> allRegionIds = response.path("items.region_id");

        for (Integer each : allRegionIds){
            assertEquals(3,each);
        }

        //verify the count is 6
        assertEquals(6,allRegionIds.size());

        //add all contries to the list
        List<String > countries = new ArrayList<>(Arrays.asList("Australia","China","India","Japan","Malaysia","Singapore"));

        List<String> allCountries = response.path("items.country_name");
        System.out.println(allCountries);

        for (int i=0;i<6;i++){
            assertTrue(allCountries.get(i).trim().equals(countries.get(i).trim()));
        }

    }

    @Test
    public void pathParamTest(){

        Response response = given().accept(ContentType.JSON)
                            .and().when().get("/countries/US");
        System.out.println(response.statusCode());
        assertEquals(200,response.statusCode());

        //verify the conten type is json
        System.out.println("Content type = " + response.contentType());
        assertEquals("application/json",response.contentType());

        String countyId = response.path("country_id");
        System.out.println(countyId);

        //verify country_id is US
        assertEquals("US",countyId);

        String countyName = response.path("country_name");

        //verify country name is United States of America
        assertEquals("United States of America",countyName);

        int region_id = response.path("region_id");

        //verify region id is 2
        assertEquals(2,region_id);
    }
}

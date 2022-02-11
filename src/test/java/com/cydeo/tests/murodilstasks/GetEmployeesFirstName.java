package com.cydeo.tests.murodilstasks;

import com.cydeo.tests.ORDSTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class GetEmployeesFirstName extends ORDSTestBase {

    @Test
    public void getKingFirstName(){


        Response response = given().accept(ContentType.JSON)
                           .and()
                           .when().get("/employees");
        System.out.println(response.statusCode());
        assertEquals(200,response.statusCode());

        System.out.println("Content type = " + response.contentType());
        assertEquals("application/json",response.contentType());

        response.prettyPrint();

        //convert to json path
        JsonPath json = response.jsonPath();

        //add all employees firstname with departement id 90 to list
        List<String> allFirstNames = json.getList("items.findAll {it.department_id = 90}.first_name");
        System.out.println(allFirstNames);

        System.out.println("First name in the list = " + allFirstNames.get(0));



    }
}

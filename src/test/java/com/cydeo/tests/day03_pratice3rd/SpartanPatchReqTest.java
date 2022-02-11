package com.cydeo.tests.day03_pratice3rd;

import com.cydeo.tests.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpartanPatchReqTest extends SpartanTestBase {


    @Test
    public void spartanRequestTest(){

        Map<String,Object> updateReq = new LinkedHashMap<>();
        updateReq.put("name","KhanBaacha");

        given().contentType(ContentType.JSON)
                .and().pathParam("id",100)
                .and().body(updateReq)
                .when().patch("api/spartans/{id}")
                .then().assertThat().statusCode(204);
    }

    //patch the phone number fot the spartan above

    @Test
    public void updatePhoneNumForSpartan(){
        Map<String,Object> newPhoneNum = new LinkedHashMap<>();
        newPhoneNum.put("phone",12345768901L);

        given().contentType(ContentType.JSON)
                .and().pathParam("id",100)
                .and().body(newPhoneNum)
                .when().patch("api/spartans/{id}")
                .then().assertThat().statusCode(204);
    }

}

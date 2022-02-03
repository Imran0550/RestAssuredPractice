package com.cydeo.tests.murodilstasks;

import com.cydeo.tests.ZippopTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class ZippopZipCodeTest extends ZippopTestBase {

    @Test
    public void zipopTest(){

        try {
            Response response = given().accept(ContentType.JSON)
                    .when().get("/us/22031");

        }catch (IllegalStateException e){
            System.out.println("Exception caught");

        }



    }
}

package com.cydeo.tests.murodilstasks;

import com.cydeo.tests.ZippopTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
public class ZippopZipCodeTest extends ZippopTestBase {

    @Test
    public void zipopTest(){

        Response response = given().accept(ContentType.JSON)
                           .when().get("/22031");
        System.out.println(response.statusCode());
    }
}

package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;
public class ZippopTestBase {

    @BeforeAll
    public static void setUp(){
        System.out.println("This comes from test base class");
        baseURI = ConfigurationReader.getProperty("zipop.url");
    }
}

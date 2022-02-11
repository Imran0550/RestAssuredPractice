package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;
public class SpartanTestBase {

    @BeforeAll
    public static void setUp(){

        System.out.println("This is coming from base class");
        baseURI = ConfigurationReader.getProperty("spartan.url");
    }
}

package com.cydeo.tests.day04_practice;

import com.cydeo.utilities.ExcelUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParameterizedPractice {

    public static   List<String > allNames (){
    List<String> names = Arrays.asList("Imran","Khan","Ahmad","Aziz");

        return names;
    }

    @ParameterizedTest
    @MethodSource("allNames")
    public void getAllNames(String names){

        System.out.println("names = " + names);

    }

    public static List<Map<String ,String >> allCredentials(){

        ExcelUtil excelUtil = new ExcelUtil("BookItQa3.xlsx","QA3");

        return excelUtil.getDataList();
    }

    @ParameterizedTest
    @MethodSource("allCredentials")
    public void getCredentials(Map<String ,String> credentials){

        System.out.println("Credentials = " + credentials);
    }
}

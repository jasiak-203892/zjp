package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Grade;
import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.entity.Subject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.*;

public class GradeControllerTest {

//    @BeforeClass
//    public static void init() {
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = 8090;
//        Grade grade = new Grade();
//        grade.setGrade(2);
//        Grade grade2 = new Grade();
//        grade2.setGrade(3);
//    }
//
//    @Test
//    public void addGrade() {
//        Grade grade = new Grade();
//        grade.setGrade(3);
//
//        assertNotNull(grade);
//        assertEquals(grade.getGrade().intValue(), 3);
//
//
//        given().body(grade)
//                .when()
//                .contentType(ContentType.JSON);
//        get("/grade/add?value=3")
//                .then().statusCode(200).assertThat();
//    }
//
//
//    @Test
//    public void getGrades() {
//        given().
//                when().
//                get("/grade/all").
//                then().
//                assertThat().
//                body("value", hasItems(3));
//    }
}
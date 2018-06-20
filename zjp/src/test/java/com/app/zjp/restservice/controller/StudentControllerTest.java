package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Student;
import org.junit.Test;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.get;
import org.junit.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentControllerTest {


    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8090;
        Student student = new Student();
        student.setAlbum(204001);
        student.setName("Marta");
        student.setEmail("204001@edu.p.lodz.pl");
    }

    @Test
    public void addNewStudent() {

            Student student = new Student();
            student.setAlbum(204001);
            student.setName("Marta");
            student.setEmail("204001@edu.p.lodz.pl");

           assertNotNull(student);
           assertEquals(student.getAlbum(), 204001);


            given().body(student)
                .when()
                .contentType(ContentType.JSON);
            get("/student/add?album=204001&name=Marta&email=204001@o.pl")
                .then().statusCode(200).assertThat();

        }

    @Test
    public void getAllStudent() {
        given().
                when().
                get("/student/all").
                then().
                assertThat().
                body("album", hasItems(204001));
    }

    @Test
    public void deleteTeacher() {
        given()
                .when ()
                .contentType (ContentType.JSON)
                .delete ("/student/delete?id=1");
    }
}
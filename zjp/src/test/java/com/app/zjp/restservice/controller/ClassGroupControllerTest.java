package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.ClassGroup;
import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.entity.Subject;
import com.app.zjp.restservice.entity.Teacher;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.*;

public class ClassGroupControllerTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8090;
        ClassGroup classGroup = new ClassGroup();
        classGroup.setName("AB");
    }


    @Test
    public void addNewClass() {

        ClassGroup classGroup = new ClassGroup();
        classGroup.setName("AB");

        assertNotNull(classGroup);
        assertEquals(classGroup.getName(), "AB");


        given().body(classGroup)
                .when()
                .contentType(ContentType.JSON);
        get("/class/add?name=AB")
                .then().statusCode(200).assertThat();

    }

//    @Test
//    public void addStudentToClass() {
//
//        ClassGroup classGroup = new ClassGroup();
//        classGroup.setName("AB");
//
//        Student student = new Student();
//        student.setAlbum(204001);
//        student.setName("Marta");
//        student.setEmail("204001@edu.p.lodz.pl");
//
//        List<Student> students = new ArrayList<>() ;
//        students.add(student);
//        classGroup.setStudents( students);
//
//        assertEquals(classGroup.getStudents().toArray().length,1 );
//    }

    @Test
    public void getAllClasses() {
        given().
                when().
                get("/class/all").
                then().
                assertThat().
                body("name", hasItems("AB"));
    }
}
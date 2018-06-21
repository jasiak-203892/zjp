package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.entity.Subject;
import com.app.zjp.restservice.entity.Teacher;
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
import static org.junit.Assert.assertEquals;

public class TeacherControllerTest {



    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8090;
        Teacher teacher = new Teacher();
        teacher.setName("PaniKtos");
        teacher.setEmail("pani@edu.p.lodz.pl");
    }

    @Test
    public void addNewTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("PaniKtos");
        teacher.setEmail("pani@edu.p.lodz.pl");


        given().body(teacher)
                .when()
                .contentType(ContentType.JSON);
        get("/teacher/add?name=PaniKtos&email=pani@o.pl")
                .then().statusCode(200).assertThat();

    }

    @Test
    public void addSubjectToTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("PaniKtos");
        teacher.setEmail("paniiii@edu.p.lodz.pl");

        Subject subject = new Subject();
        subject.setName("Matematyka");

        List<Subject> subjects = new ArrayList<>() ;
        subjects.add(subject);
        teacher.setSubjects(subjects);

        assertEquals(teacher.getSubjects().get(0).getName(),subject.getName() );

    }

    @Test
    public void getAllTeachers() {
        given().
                when().
                get("/teacher/all").
                then().
                assertThat().
                body("name", hasItems("PaniKtos"));
    }

    @Test
    public void deleteTeacher() {
        given()
                .when ()
                .contentType (ContentType.JSON)
                .delete ("/teacher/delete?id=1");
    }
}
package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.entity.Subject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.*;

public class SubjectControllerTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8090;
        Subject subject = new Subject();
        subject.setName("Matematyka");
    }

    @Test
    public void addNewSubject() {
        Subject subject = new Subject();
        subject.setName("Matematyka");

        assertNotNull(subject);
        assertEquals(subject.getName(), "Matematyka");


        given().body(subject)
                .when()
                .contentType(ContentType.JSON);
        get("/subjects/add?name=Matematyka")
                .then().statusCode(200).assertThat();
    }

    @Test
    public void getAllSubjects() {
        given().
                when().
                get("/subjects/all").
                then().
                assertThat().
                body("name", hasItems("Matematyka"));
    }

    @Test
    public void deleteSubject() {
        given()
                .when ()
                .contentType (ContentType.JSON)
                .delete ("/subjects/delete?id=1");
    }
}
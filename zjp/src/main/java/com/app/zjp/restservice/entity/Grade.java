package com.app.zjp.restservice.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grade {

    @Id
    private Integer id;
    private Integer grades;

    public Integer getId() {return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {return grades; }

    public void setGrade(Integer grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grades=" + grades +
                '}';
    }
}

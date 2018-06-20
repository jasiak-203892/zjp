package com.app.zjp.restservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(targetEntity=Grade.class)
    private ArrayList<Grade> grades;

    public ArrayList<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	public Integer getId() {return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {return name; }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name='" + name + '\'' + '}'; }
}

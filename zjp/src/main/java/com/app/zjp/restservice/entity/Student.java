package com.app.zjp.restservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int album;
    private String name;
    private String email;

    @ManyToOne
    @JsonIgnore
    private ClassGroup classGroup;
   
	@OneToMany(targetEntity=Subject.class)
    private List<Subject> subjects;
	
    public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassGroup getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(ClassGroup classGroup) {
        this.classGroup = classGroup;
    }

    @Override
    public String toString() {
        return "Student{id=" + album + ", name='" + name + "', email='" + email + "'}";
    }
}

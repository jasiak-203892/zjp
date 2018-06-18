package com.app.zjp.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.zjp.restservice.entity.Student;

@RepositoryRestResource(path = "/students")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

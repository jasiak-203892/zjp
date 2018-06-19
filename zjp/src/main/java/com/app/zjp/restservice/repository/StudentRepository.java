package com.app.zjp.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.zjp.restservice.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}

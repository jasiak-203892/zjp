package com.app.zjp.restservice.repository;

import com.app.zjp.restservice.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/grades")
public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
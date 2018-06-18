package com.app.zjp.restservice.repository;

import com.app.zjp.restservice.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/subject")
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
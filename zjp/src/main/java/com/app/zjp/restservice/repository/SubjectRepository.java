package com.app.zjp.restservice.repository;

import com.app.zjp.restservice.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/subjects")
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
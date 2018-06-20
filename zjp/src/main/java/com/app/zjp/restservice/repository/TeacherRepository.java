package com.app.zjp.restservice.repository;

import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}

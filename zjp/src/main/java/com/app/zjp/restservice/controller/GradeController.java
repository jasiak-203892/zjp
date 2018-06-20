package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Grade;
import com.app.zjp.restservice.entity.Subject;
import com.app.zjp.restservice.entity.Teacher;
import com.app.zjp.restservice.repository.GradeRepository;
import com.app.zjp.restservice.repository.SubjectRepository;
import com.app.zjp.restservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(path="/grade")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    void addGrade (@RequestParam Integer value) {
        Grade grade = new Grade();
        grade.setGrade(value);
        gradeRepository.save(grade);
    }

    @GetMapping(path="/positives")
    public @ResponseBody
    Iterable<Grade> getPositiveGrades() {
        Iterable<Grade> grades = gradeRepository.findAll();
        return StreamSupport.stream(grades.spliterator(), false).filter(x -> x.getGrade() > 2).collect(Collectors.toList());
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Grade> getGrades() {
        return gradeRepository.findAll();
    }
}

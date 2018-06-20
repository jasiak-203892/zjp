package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Subject;
import com.app.zjp.restservice.entity.Teacher;
import com.app.zjp.restservice.repository.SubjectRepository;
import com.app.zjp.restservice.repository.TeachertRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/teacher")
public class TeacherController {
    @Autowired
    private TeachertRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewTeacher (@RequestParam String name, @RequestParam String email) {
        Teacher n = new Teacher();
        n.setName(name);
        n.setEmail(email);
        teacherRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/{id}/add-subject")
    public @ResponseBody
    String addSubjectToTeacher (@PathVariable("id") Integer id, @RequestParam Integer subjectId) {
        Optional<Teacher> option = teacherRepository.findById(id);
        if (option.isPresent()){
            Optional<Subject> subjectOption = subjectRepository.findById(subjectId);
            if (subjectOption.isPresent()){
                Teacher teacher = option.get();
                Subject subject = subjectOption.get();

                if (!teacher.getSubjects().contains(subject)){
                    teacher.getSubjects().add(subject);
                    teacherRepository.save(teacher);
                } else {
                    return "Teacher already has subject with this id!";
                }
            } else {
                return String.format("Subject with id %d does not exists!", subjectId);
            }
        } else {
            return String.format("Teacher with id %d does not exists!", id);
        }
        return "Added!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
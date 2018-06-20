package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.ClassGroup;
import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.repository.ClassGroupRepository;
import com.app.zjp.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path="/class")
public class ClassGroupController {
    @Autowired
    private ClassGroupRepository classGroupRepositoy;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewClass (@RequestParam String name) {
        ClassGroup n = new ClassGroup();
        n.setName(name);
        classGroupRepositoy.save(n);
        return "Saved";
    }

    @GetMapping(path="/{id}/add-student")
    public @ResponseBody
    String addStudentToClass (@PathVariable("id") Integer id, @RequestParam Integer studentId) {
        Optional<ClassGroup> option = classGroupRepositoy.findById(id);
        if (option.isPresent()){
            Optional<Student> subjectOption = studentRepository.findById(studentId);
            if (subjectOption.isPresent()){
                ClassGroup classGroup = option.get();
                Student student = subjectOption.get();

                if (!classGroup.getStudents().contains(student)){
                    student.setClassGroup(classGroup);
                    studentRepository.save(student);
                } else {
                    return "Class already has student with this id!";
                }
            } else {
                return String.format("Student with id %d does not exists!", studentId);
            }
        } else {
            return String.format("Class with id %d does not exists!", id);
        }
        return "Added!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ClassGroup> getAllClasses() {
        return classGroupRepositoy.findAll();
    }
}
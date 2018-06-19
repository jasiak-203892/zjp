package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Teacher;
import com.app.zjp.restservice.repository.TeachertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/teacher")
public class TeacherController {
    @Autowired
    private TeachertRepository teacherRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewTeacher (@RequestParam String name, @RequestParam String email) {
        Teacher n = new Teacher();
        n.setName(name);
        n.setEmail(email);
        teacherRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewStudent (@RequestParam Integer album, @RequestParam String name, @RequestParam String email) {
        Student n = new Student();
        n.setAlbum(album);
        n.setName(name);
        n.setEmail(email);
        studentRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
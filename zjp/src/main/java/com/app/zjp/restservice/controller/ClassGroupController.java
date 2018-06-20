package com.app.zjp.restservice.controller;

import com.app.zjp.restservice.entity.ClassGroup;
import com.app.zjp.restservice.entity.Student;
import com.app.zjp.restservice.repository.ClassGroupRepository;
import com.app.zjp.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/class")
public class ClassGroupController {
    @Autowired
    private ClassGroupRepository classGroupRepositoy;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewClass (@RequestParam String name) {
        ClassGroup n = new ClassGroup();
        n.setName(name);
        classGroupRepositoy.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ClassGroup> getAllClasses() {
        return classGroupRepositoy.findAll();
    }
}
package com.app.zjp.restservice.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.zjp.restservice.entity.Subject;
import com.app.zjp.restservice.repository.SubjectRepository;

@Controller
@RequestMapping(path="/subjects")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewSubject (@RequestParam String name) {
        Subject subject = new Subject();
        subject.setName(name);
        subjectRepository.save(subject);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    @GetMapping(path="/delete")
    public @ResponseBody
    String deleteTeacher (@RequestParam Integer id) {
        Subject subjectToDelete = new Subject();
        Optional<Subject> option = subjectRepository.findById(id);
        if(option.isPresent()) {
        	subjectToDelete=option.get();
        	subjectRepository.delete(subjectToDelete);
        }
        else {
        	return "No subject with this ID";
        }

        return "Subject has been deleted";
    }
}

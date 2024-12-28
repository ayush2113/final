package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Subject;
import com.studentmanagementsystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /*
    *
    * Get Subject by ID
    *
    * */
    @GetMapping(value = "/{id}")
    public Subject findById(@PathVariable("id") int id){
        return subjectService.findById(id);
    }
        
    /*
    *
    * Get Subject by Name
    *
    * */
    @GetMapping(value = "/student-name-{name}")
    public List<Subject> findByNameContaining(@PathVariable("name") String name){
        return subjectService.findByNameContaining(name);
    }

    /*
    *
    * Get All Subject's
    *
    * */
    @GetMapping
    public List<Subject> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ){
        return subjectService.findAll(PageRequest.of(pageNumber,pageSize));
    }

    /*
    *
    * Get All Student's by Name
    *
    * */
    @GetMapping(value = "/name-{name}")
    public List<Student> findAllByName(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize,
            @PathVariable("name") String name
    ){
        return subjectService.findAllByName(PageRequest.of(pageNumber, pageSize),name);
    }
        
}

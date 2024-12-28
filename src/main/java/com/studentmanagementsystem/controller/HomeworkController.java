package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.entity.Homework;
import com.studentmanagementsystem.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/homework")
public class HomeworkController{
    @Autowired
    private HomeworkService service;

    /*
    *
    * Add New Homework
    *
    * */
    @PostMapping
    public Homework save(@RequestBody Homework homework) {
        return service.save(homework);
    }

    /*
    *
    * Get Homework by ID
    *
    * */
    @GetMapping("/{id}")
    public Homework findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    /*
    *
    * Get All Homework
    *
    * */
    @GetMapping
    public List<Homework> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ) {
        return service.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    /*
    *
    * Get Homework by Date Created
    *
    * */
    @GetMapping("date-created-{date}")
    public List<Homework> findByDateCreated(@PathVariable("date") Date date) {
        return service.findByDateCreated(date);
    }

    /*
    *
    * Get Homework by Details
    *
    * */
    @GetMapping("homework-details-{details}")
    public List<Homework> findByDetailsContaining(@PathVariable String details) {
        return service.findByDetailsContaining(details);
    }

    /*
    *
    * Get Homework by Specific Grade
    *
    * */
    @GetMapping("grade-obtained-{grade}")
    public List<Homework> findByGradeObtained(@PathVariable("grade") String grade) {
        return service.findByGradeObtained(grade);
    }

    /*
    *
    * Get Homework by Grade List
    *
    * */
    @GetMapping("grade-in-{str}")
    public List<Homework> findByGradeObtainedIsIn(@PathVariable("str") List<String> str) {
        System.out.println(str);
        return service.findByGradeObtainedIsIn(str);
    }

    /*
    *
    * Get Homework by Homework Content
    *
    * */
    @GetMapping("/content-{content}")
    public List<Homework> findByContentContaining(@PathVariable("content") String content) {
        return service.findByContentContaining(content);
    }

    /*
    *
    * Add All Homework
    *
    * */
    @PostMapping("/save-all")
    public List<Homework> saveAll(@RequestBody List<Homework> list) {
        return service.saveAll(list);
    }

}

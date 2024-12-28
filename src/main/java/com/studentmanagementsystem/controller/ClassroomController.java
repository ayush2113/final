package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    /*
    *
    * Add New Class Room
    *
    * */
    @PostMapping
    public Classroom save(Classroom classroom) {
        return classroomService.save(classroom);
    }

    /*
    *
    * Get Class Room By ID
    *
    * */
    @GetMapping("/{id}")
    public Classroom findById(@PathVariable("id") int id) {
        return classroomService.findById(id);
    }

    /*
    *
    * Get All Class Room's
    *
    * */
    @GetMapping
    public List<Classroom> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ) {
        return classroomService.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    /*
    *
    * Get Class Room
    *
    * */
    @GetMapping("/name-{name}")
    public Classroom findByName(@PathVariable("name") String name) {
        return classroomService.findByName(name);
    }

    /*
    *
    * Get Class Room By Code
    *
    * */
    @GetMapping("/code-{code}")
    public Classroom findByCode(@PathVariable("code") String code) {
        return classroomService.findByCode(code);
    }

    /*
    *
    * Delete Class Room By ID
    *
    * */
    @DeleteMapping("/{id}")
    public Classroom deleteById(@PathVariable("id") int id) {
        return classroomService.deleteById(id);
    }

    /*
    *
    * Delete Class Room By Code
    *
    * */
    @DeleteMapping("/code-{code}")
    public Classroom deleteByCode(@PathVariable("code") String code) {
        return classroomService.deleteByCode(code);
    }

    /*
    *
    * Delete Class Room By Name
    *
    * */
    @DeleteMapping("/name-{name}")
    public Classroom deleteByName(@PathVariable("name") String name) {
        return classroomService.deleteByName(name);
    }

}

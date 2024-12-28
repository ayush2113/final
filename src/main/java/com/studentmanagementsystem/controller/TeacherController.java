package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Teacher;
import com.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /*
    *
    * Get Teacher by ID
    *
    * */
    @GetMapping(value = "/{id}")
    public Teacher findById(@PathVariable("id") int id){
        return teacherService.findById(id);
    }

    /*
    *
    * Get Teacher List by First-Name
    *
    * */
    @GetMapping(value = "/first-name-{firstName}")
    public List<Teacher> findByFirstNameContaining(@PathVariable("firstName") String firstName){
        return teacherService.findByFirstNameContaining(firstName);
    }

    /*
    *
    * Get Teacher List by Middle-Name
    *
    * */
    @GetMapping(value = "/middle-name-{middleName}")
    public List<Teacher> findByMiddleNameContaining(@PathVariable("middleName") String middleName){
        return teacherService.findByMiddleNameContaining(middleName);
    }

    /*
    *
    * Get Teacher by Last-Name
    *
    * */
    @GetMapping(value = "/last-name-{lastName}")
    public List<Teacher> findByLastNameContaining(@PathVariable("lastName") String lastName){
        return teacherService.findByLastNameContaining(lastName);
    }

    /*
    *
    * Get Teacher by Email ID
    *
    * */
    @GetMapping(value = "/email-{emailId}")
    public List<Teacher> findByEmailContaining(@PathVariable("emailId") String email){
        return teacherService.findByEmailContaining(email);
    }

    /*
    *
    * Get Teacher by Phone Number
    *
    * */
    @GetMapping(value = "/phone-number-{phoneNumber}")
    public List<Teacher> findByPhoneNumberContaining(@PathVariable("phoneNumber") String phoneNumber){
        return teacherService.findByPhoneNumberContaining(phoneNumber);
    }

    /*
    *
    * Get Teacher by Gender
    *
    * */
    @GetMapping(value = "/gender-{gender}")
    public List<Teacher> findByGenderContaining(@PathVariable("gender") String gender){
        return teacherService.findByGenderContaining(gender);
    }

    /*
    *
    * Get Teacher by First-Name, Middle-Name and Last-Name
    *
    * */
    @GetMapping(value = "/first-name-{firstName}-middle-name-{middleName}-last-name-{lastName}-email-{email}")
    public List<Teacher> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(@PathVariable("firstName") String firstName, @PathVariable("middleName") String middleName, @PathVariable("lastName") String lastName, @PathVariable("email") String email){
        return teacherService.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    /*
    *
    * Get Teacher List by Pagination
    *
    * */
    @GetMapping
    public List<Teacher> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ){
        return teacherService.findAll(PageRequest.of(pageNumber,pageSize));
    }

    /*
    *
    * Delete Teacher by ID
    *
    * */
    @DeleteMapping(value = "/{id}")
    public Teacher deleteById(@PathVariable("id") int id){
        return teacherService.deleteById(id);
    }
}

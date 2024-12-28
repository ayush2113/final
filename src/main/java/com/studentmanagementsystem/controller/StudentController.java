package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*
    *
    * Get Student by ID
    *
    * */
    @GetMapping(value = "/{id}")
    public Student findById(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    /*
    *
    * Get Student by Email Contating
    *
    * */
    @GetMapping(value = "/email-{emailId}")
    public Student findByEmailContaining(@PathVariable("emailId") String email){
        return studentService.findByEmailContaining(email);
    }

    /*
    *
    * Get Student by Email and School
    *
    * */
    @GetMapping(value = "/email-{emailId}-school-{schoolId}")
    public Student findByEmailContaining(@PathVariable("emailId") String email, @PathVariable("schoolId") int schoolId){
        return studentService.findByEmailContaining(email, schoolId);
    }

    /*
    *
    * Get Student by Phone-Number
    *
    * */
    @GetMapping(value = "/phone-number-{mobile}")
    public List<Student> findByPhoneNumber(@PathVariable("mobile") String mobile){
        return studentService.findByPhoneNumber(mobile);
    }

    /*
    *
    * Get Student by First Name
    *
    * */
    @GetMapping("/first-name-{firstName}")
    public List<Student> findByFirstNameContaining(@PathVariable("firstName") String firstName){
        return studentService.findByFirstNameContaining(firstName);
    }

    /*
    *
    * Get Student by Middle Name
    *
    * */
    @GetMapping(value = "/middle-name-{middleName}")
    public List<Student> findByMiddleNameContaining(@PathVariable("middleName") String middleName){
        return studentService.findByMiddleNameContaining(middleName);
    }

    /*
    *
    * Get Student by Last Name
    *
    * */
    @GetMapping(value = "/last-name-{lastName}")
    public List<Student> findByLastNameContaining(@PathVariable("lastName") String lastName){
        return studentService.findByLastNameContaining(lastName);
    }

    /*
    *
    * Get Student by First-Name, Middle-Name and Last-Name
    *
    * */
    @GetMapping(value = "/first-name-{firstName}-middle-name-{middleName}-last-name-{lastName}-email-{email}")
    public List<Student> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(@PathVariable("firstName") String firstName, @PathVariable("middleName") String middleName, @PathVariable("lastName") String lastName, @PathVariable("email") String email){
        return studentService.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    /*
    *
    * Get All Students by Pagination
    *
    * */
    @GetMapping
    public List<Student> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ){
        return studentService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Delete Student by ID
    *
    * */
    @DeleteMapping(value = "/{id}")
    public Student deleteById(@PathVariable("id") int id){
        return studentService.deleteById(id);
    }

    /*
    *
    * Update Student by ID
    *
    * */
    @PutMapping(value = "/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        student.setId(studentId);
        return studentService.save(student);
    }

    /*
    *
    * Add New Student
    *
    * */
    @PostMapping
    public Student save(@RequestBody Student newStudent){
        return studentService.save(newStudent);
    }

}

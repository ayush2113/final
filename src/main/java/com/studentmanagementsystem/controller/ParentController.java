package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Parent;
import com.studentmanagementsystem.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/parent")
public class ParentController {
    @Autowired
    private ParentService parentService;

    /*
    *
    * Get All Parent's
    *
    * */
    @GetMapping
    public List<Parent> findAll(Pageable pageable){
        return parentService.findAll(pageable);
    }

    /*
    *
    * Get Parent's By ID
    *
    * */
    @GetMapping(value = "/{id}")
    public Parent findById(@PathVariable("id") int id){
        return parentService.findById(id);
    }

    /*
    *
    * Get Parent's by First-Name
    *
    * */
    @GetMapping(value = "/first-name-{firstName}")
    public List<Parent> findByFirstNameContaining(@PathVariable("firstName") String name){
        return parentService.findByFirstNameContaining(name);
    }

    /*
    *
    * Get Parent's by Middle-Name
    *
    * */
    @GetMapping(value = "/middle-name-{middleName}")
    public List<Parent> findByMiddleNameContaining(@PathVariable("middleName") String name){
        return parentService.findByMiddleNameContaining(name);
    }

    /*
    *
    * Get Parent's by Last-Name
    *
    * */
    @GetMapping(value = "/last-name-{lastName}")
    public List<Parent> findByLastNameContaining(@PathVariable("lastName") String name){
        return parentService.findByLastNameContaining(name);
    }

    /*
    *
    * Get Parent's by First-Name and Last-Name
    *
    * */
    @GetMapping(value = "/fist-name-{firstName}-last-name-{lastName}")
    public List<Parent> findByFirstNameAndMiddleNameContaining(@PathVariable("firstName") String firstName,@PathVariable("lastName") String middleName){
        return parentService.findByFirstNameAndMiddleNameContaining(firstName, middleName);
    }

    /*
    *
    * Get Parent's by First-Name and Last-Name
    *
    * */
    @GetMapping(value = "/last-name-{lastNAme}-first-name-{firstName}")
    public List<Parent> findByLastNameAndFirstNameContaining(@PathVariable("lastNAme") String lastName,@PathVariable("firstName") String firstName){
        return parentService.findByLastNameAndFirstNameContaining(lastName, firstName);
    }

    /*
    *
    * Get Parent's by First-Name and Last-Name
    *
    * */
    @GetMapping(value = "/first-name-{firstName}-middle-name-{middleName}-last-name-{lastName}")
    public List<Parent> findByFirstNameAndMiddleNameAndLastNameContaining(@PathVariable("firstName") String firstName,@PathVariable("middleName") String middleName,@PathVariable("lastName") String lastName){
        return parentService.findByFirstNameAndMiddleNameAndLastNameContaining(firstName, middleName, lastName);
    }

}

package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.School;
import com.studentmanagementsystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    /*
    *
    * Add / Update School Address
    *
    * */
    @PutMapping(value = "/{schoolId}-school-{addressId}-address")
    public School updateSchoolAddress(@PathVariable("schoolId") int schoolId, @PathVariable("addressId") int addressId) {
        return schoolService.updateSchoolAddress(schoolId, addressId);
    }

    /*
    *
    * Add / Update School Student
    *
    * */
    @PutMapping(value = "/{schoolId}-school-{studentId}-student")
    public School updateSchoolStudent(@PathVariable("schoolId") int schoolId,@PathVariable("studentId") int studentId){
        return schoolService.updateSchoolStudent(schoolId, studentId);
    }

    /*
    *
    * Add / Update School Teacher
    *
    * */
    @PutMapping(value = "/{schoolId}-school-{teacherId}-teacher")
    public School updateSchoolTeachers(@PathVariable("schoolId") int schoolId, @PathVariable("teacherId")  int teacherId){
        return schoolService.updateSchoolTeachers(schoolId, teacherId);
    }

    /*
    *
    * School by I'd
    *
    * */
    @GetMapping(value = "/{id}")
    public School findById(@PathVariable(value = "id") int id){
        return schoolService.findById(id);
    }

    /*
    *
    * Save School
    *
    * */
    @PostMapping
    public School save(@RequestBody School school){
        return schoolService.save(school);
    }
    /*
    *
    * Delete School by Id
    *
    * */
    @DeleteMapping(value = "/{id}")
    public School deleteById(@PathVariable(value = "id") int id){
        return schoolService.deleteById(id);
    }

    /*
    *
    * Find school by Name
    *
    * */
    @GetMapping(value = "/school-name-{name}")
    public School findByName(@PathVariable(value = "name") String name){
        return schoolService.findByName(name);
    }

    /*
    *
    * Find School Name Containing
    *
    * */
    @GetMapping(value = "/school-{name}-name")
    public List<School> findByNameContaining(@PathVariable(value = "name") String name){
        return schoolService.findByNameContaining(name);
    }

    /*
    *
    * Get all School by Pagination
    *
    * */
    @GetMapping
    public List<School> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ){
        return schoolService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Find School by Principle Name Containing
    *
    * */
    @GetMapping(value = "/school-principle-{principle}")
    public List<School> findByPrincipleContaining(@PathVariable(value = "principle") String principle){
        return schoolService.findByPrincipleContaining(principle);
    }

    /*
    *
    * Find School by School Details
    *
    * */
    @GetMapping(value = "/school-details-{details}")
    public List<School> findByDetailsContaining(@PathVariable(value = "details") String details){
        return schoolService.findByDetailsContaining(details);
    }

}

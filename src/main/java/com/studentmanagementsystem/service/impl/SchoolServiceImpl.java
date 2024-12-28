package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.entity.School;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Teacher;
import com.studentmanagementsystem.repo.SchoolRepository;
import com.studentmanagementsystem.service.AddressService;
import com.studentmanagementsystem.service.SchoolService;
import com.studentmanagementsystem.service.StudentService;
import com.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    /*
    *
    * School by Id
    *
    * */
    @Override
    public School findById(int id) {
        return schoolRepository.findById(id);
    }

    /*
    *
    * Save School
    *
    * */
    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    /*
    *
    * Add / Update School Address
    *
    * */
    @Override
    public School updateSchoolAddress(int schoolId, int addressId) {
        Address address = addressService.findById(addressId);
        School school = schoolRepository.findById(schoolId);
        school.setAddress(address);
        return schoolRepository.save(school);
    }

    /*
    *
    * Add / Update School Student
    *
    * */
    @Override
    public School updateSchoolStudent(int schoolId, int studentId) {
        School school = schoolRepository.findById(schoolId);
        Student student = studentService.findById(studentId);
        student.setSchool(school);
        return school;
    }

    /*
    *
    * Add / Update School Teacher
    *
    * */
    @Override
    public School updateSchoolTeachers(int schoolId, int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        School school = schoolRepository.findById(schoolId);
        teacher.setSchools(school);
        teacherService.save(teacher);
        return school;
    }

    /*
    *
    * Delete School by Id
    *
    * */
    @Override
    public School deleteById(int id) {
        return schoolRepository.deleteById(id);
    }

    /*
    *
    * Find school by Name
    *
    * */
    @Override
    public School findByName(String name) {
        return schoolRepository.findByName(name);
    }

    /*
    *
    * Find School Name Containing
    *
    * */
    @Override
    public List<School> findByNameContaining(String name) {
        return schoolRepository.findByNameContaining(name);
    }

    /*
    *
    * Get all School by Pagination
    *
    * */
    @Override
    public List<School> findAll(Pageable pageable) {
        return schoolRepository.findAll(pageable).getContent();
    }

    /*
    *
    * Find School by Principle Name Containing
    *
    * */
    @Override
    public List<School> findByPrincipleContaining(String principle) {
        return schoolRepository.findByPrincipleContaining(principle);
    }

    /*
    *
    * Find School by School Details
    *
    * */
    @Override
    public List<School> findByDetailsContaining(String details) {
        return schoolRepository.findByDetailsContaining(details);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init() {
        if (schoolRepository.count() == 0) {
            for (int i = 1; i <= 50; i++) {
                School school = new School();

                school.setName(new RandomNameGenerator().next(26,50));

                school.setPrinciple(new RandomNameGenerator().next(26,20));

                school.setDetails(new RandomNameGenerator().next(26,100));

                schoolRepository.save(school);
            }
        }
/*
        for (int i = 0; i < 50; i++) {
            List<Teacher> tList = teacherService.findAll(PageRequest.of(i, 4000));
            for (Teacher teacher : tList){
                updateSchoolTeachers(i+1, teacher.getId());
            }
        }
*/
    }
}

package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.School;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SchoolService {
    School findById(int id);

    School save(School school);

    School updateSchoolAddress(int schoolId, int addressId);

    public School updateSchoolStudent(int schoolId, int studentId);

    School updateSchoolTeachers(int schoolId, int teacherId);

    School deleteById(int id);

    School findByName(String name);

    List<School> findByNameContaining(String name);

    public List<School> findAll(Pageable pageable);

    List<School> findByPrincipleContaining(String principle);

    List<School> findByDetailsContaining(String details);

}

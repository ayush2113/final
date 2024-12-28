package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Student findById(int id);

    Student save(Student student);

    Student findByEmailContaining(String email);

    Student findByEmailContaining(String email, int schoolId);

    List<Student> findByPhoneNumber(String mobile);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByMiddleNameContaining(String middleName);

    List<Student> findByLastNameContaining(String lastName);

    List<Student> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email);

    List<Student> findAll(Pageable pageable);

    Student deleteById(int id);
}

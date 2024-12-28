package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {
    Teacher findById(int id);

    Teacher save(Teacher teacher);

    List<Teacher> findByFirstNameContaining(String firstName);

    List<Teacher> findByMiddleNameContaining(String middleName);

    List<Teacher> findByLastNameContaining(String lastName);

    List<Teacher> findByEmailContaining(String email);

    List<Teacher> findByPhoneNumberContaining(String phoneNumber);

    List<Teacher> findByGenderContaining(String gender);

    List<Teacher> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email);

    List<Teacher> findAll(Pageable pageable);

    Teacher deleteById(int id);
}

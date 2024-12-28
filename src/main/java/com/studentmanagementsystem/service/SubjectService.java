package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Subject;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {
    Subject findById(int id);

    Subject save(Subject subject);

    List<Subject> findByNameContaining(String name);

    List<Subject> findAll(Pageable pageable);

    List<Student> findAllByName(Pageable pageable, String name);
}

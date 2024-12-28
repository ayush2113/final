package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.entity.Homework;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface HomeworkService {
    Homework save(Homework homework);

    Homework update(int homeworkId, Homework updatedHomework);

    Homework findById(int id);

    Page<Homework> findAll(Pageable pageable);

    List<Homework> findByDateCreated(Date date);

    List<Homework> findByDetailsContaining(String details);

    List<Homework> findByGradeObtained(String grade);

    List<Homework> findByGradeObtainedIsIn(List<String> str);

    List<Homework> findByContentContaining(String content);

    List<Homework> saveAll(List<Homework> list);
}

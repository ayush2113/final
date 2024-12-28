package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Report;
import com.studentmanagementsystem.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<Report> findAll(Pageable pageable);

    Report save(Report report);

    Report findById(int id);

    Report deleteById(int id);

    List<Report> findByDateCreated(Date created);

    List<Report> findByContentContaining(String content);

    List<Report> findByTeacherCommentContaining(String comment);

    List<Report> findByStudent(Student student);
}

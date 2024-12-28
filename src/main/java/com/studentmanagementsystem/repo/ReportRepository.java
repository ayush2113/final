package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Report;
import com.studentmanagementsystem.entity.Student;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@NonNullApi
public interface ReportRepository extends JpaRepository<Report, Integer> {
    Page<Report> findAll(Pageable pageable);

    Report save(Report report);

    Report findById(int id);

    Report deleteById(int id);

    List<Report> findByDateCreated(Date created);

    List<Report> findByContentContaining(String content);

    List<Report> findByTeacherCommentContaining(String comment);

    List<Report> findByStudent(Student student);
}

package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Homework;
import io.micrometer.common.lang.NonNullApi;
import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@NonNullApi
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    Homework save(@Nonnull Homework homework);

    Homework findById(int id);

    Page<Homework> findAll(@Nonnull Pageable pageable);

    List<Homework> findByDateCreated(Date date);

    List<Homework> findByDetailsContaining(String details);

    List<Homework> findByGradeObtained(String grade);

    List<Homework> findByGradeObtainedIsIn(List<String> str);

    List<Homework> findByContentContaining(String content);
}

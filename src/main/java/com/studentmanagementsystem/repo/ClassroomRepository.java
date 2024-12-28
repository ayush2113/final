package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Classroom;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@NonNullApi
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    Classroom save(Classroom classroom);

    Classroom findById(int id);

    Classroom findByName(String name);

    Classroom findByCode(String code);

    Page<Classroom> findAll(Pageable pageable);

    Classroom deleteById(int id);

    Classroom deleteByCode(String code);

    Classroom deleteByName(String name);
}

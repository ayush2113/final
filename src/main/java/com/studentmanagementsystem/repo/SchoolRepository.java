package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.School;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface SchoolRepository extends JpaRepository<School, Integer> {
    School findById(int id);

    School save(School school);

    School deleteById(int id);

    School findByName(String name);

    List<School> findByNameContaining(String name);

    Page<School> findAll(Pageable pageable);

    List<School> findByPrincipleContaining(String principle);

    List<School> findByDetailsContaining(String details);

}

package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Teacher;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findById(int id);

    Teacher save(Teacher teacher);

    List<Teacher> findByFirstNameContaining(String firstName);

    List<Teacher> findByMiddleNameContaining(String middleName);

    List<Teacher> findByLastNameContaining(String lastName);

    List<Teacher> findByEmailContaining(String email);

    List<Teacher> findByPhoneNumberContaining(String phoneNumber);

    List<Teacher> findByGenderContaining(String gender);

    List<Teacher> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email);

    Page<Teacher> findAll(Pageable pageable);

    Teacher deleteById(int id);
}

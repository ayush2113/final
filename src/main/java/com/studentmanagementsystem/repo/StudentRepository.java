package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Student;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);

    Student save(Student student);

    Student findByEmailContaining(String email);

    @Query(
            value = "select student.id, " +
                    "student.firstName, " +
                    "student.lastName, " +
                    "student.middleName, " +
                    "student.email, " +
                    "student.phoneNumber " +
                    "from Student student " +
                    "inner join School sch " +
                    "on student.school=sch.id " +
                    "where student.email=?1 and sch.id=?2",
            nativeQuery = true
    )
    Student findByEmailContaining(String email, int schoolId);

    List<Student> findByPhoneNumber(String mobile);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByMiddleNameContaining(String middleName);

    List<Student> findByLastNameContaining(String lastName);

    List<Student> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email);

    Page<Student> findAll(Pageable pageable);

    Student deleteById(int id);
}

package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Users;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface UserRepository extends JpaRepository<Users, String> {

    Users save(Users users);

    Users findByUserId(String id);

    Users findByEmailId(String email);

    Page<Users> findAll(Pageable pageable);

    @Query(value = "select * from Users where Users.role=?1", nativeQuery = true)
    List<Users> findByRole(String role, Pageable pageable);

    List<Users> findByFirstNameContaining(String firstName, Pageable pageable);

    List<Users> findByMiddleNameContaining(String middleName, Pageable pageable);

    List<Users> findByLastNameContaining(String lastName, Pageable pageable);

    List<Users> findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(String firstName, String middleName, String lastName, Pageable pageable);

    @Query(value = "select * from Users where Users.phoneNumber=?1", nativeQuery = true)
    List<Users> findByPhoneNumberContaining(String phoneNumber, Pageable pageable);

    @Query(value = "select * from Users where Users.isSuperAdminAccess=?1", nativeQuery = true)
    List<Users> findByIdSuperAdminAccess(boolean isSuperAdmin, Pageable pageable);

    @Query(value = "select * from Users where Users.isAdminAccess=?1", nativeQuery = true)
    List<Users> findByIsAdminAccess(boolean isAdmin, Pageable pageable);

    @Query(value = "select * from Users where Users.isPrincipleAccess=?1", nativeQuery = true)
    List<Users> findByIsPrincipleAccess(boolean isPrinciple, Pageable pageable);

    @Query(value = "select * from Users where Users.isTeacherAccess=?1", nativeQuery = true)
    List<Users> findByIsTeacherAccess(boolean isTeacher, Pageable pageable);

    @Query(value = "select * from Users where Users.isStudentAccess=?1", nativeQuery = true)
    List<Users> findByIsStudentAccess(boolean isStudent, Pageable pageable);

    @Query(value = "select * from Users where Users.isParentAccess=?1", nativeQuery = true)
    List<Users> findByIsParentAccess(boolean isParent, Pageable pageable);
}

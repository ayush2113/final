package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Users;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface UserService {

    Users save(Users users);

    Users update(Users users);

    Users findByEmailId(String email);


//    Users findByEmailIdContaining(String emailId, Pageable pageable);

//    Page<Users> findAll(Pageable pageable);

    List<Users> findByRole(String role, Pageable pageable);

    List<Users> findAll(Pageable pageable);

    List<Users> findByFirstNameContaining(String firstName, Pageable pageable);

    List<Users> findByMiddleNameContaining(String middleName, Pageable pageable);

    List<Users> findByLastNameContaining(String lastName, Pageable pageable);

    List<Users> findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(String firstName, String middleName, String lastName, Pageable pageable);

    List<Users> findByPhoneNumberContaining(String phoneNumber, Pageable pageable);

    List<Users> findByIdSuperAdminAccess(boolean isSuperAdmin, Pageable pageable);

    List<Users> findByIsAdminAccess(boolean isAdmin, Pageable pageable);

    List<Users> findByIsPrincipleAccess(boolean isPrinciple, Pageable pageable);

    List<Users> findByIsTeacherAccess(boolean isTeacher, Pageable pageable);

    List<Users> findByIsStudentAccess(boolean isStudent, Pageable pageable);

    List<Users> findByIsParentAccess(boolean isParent, Pageable pageable);

    Users findByUserId(String id);

    Boolean login(Users users);

    Boolean logout(Users users);

    Map<String, Object> authData(Users users);
}

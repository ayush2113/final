package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Users;
import com.studentmanagementsystem.repo.UserRepository;
import com.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /*
    *
    * Get User Role
    *
    * */
    private String getRole(Users users){
        String role = "NA";
        if (users.getIsSuperAdminAccess()){
            role = "superadmin";
        } else if (users.getIsAdminAccess()) {
            role = "admin";
        } else if (users.getIsPrincipleAccess()) {
            role = "principle";
        } else if (users.getIsTeacherAccess()) {
            role = "teacher";
        } else if (users.getIsStudentAccess()) {
            role = "student";
        } else if (users.getIsParentAccess()) {
            role = "parent";
        }
        return role;
    }

    private Users setUserAccess(Users users,boolean value){
        users.setIsSuperAdminAccess(value);
        users.setIsAdminAccess(value);
        users.setIsPrincipleAccess(value);
        users.setIsTeacherAccess(value);
        users.setIsStudentAccess(value);
        users.setIsParentAccess(value);
        return users;
    }

    /*
    *
    * Save User
    *
    * */
    @Override
    public Users save(Users users) {

        if (userRepository.findByEmailId(users.getEmailId()) != null) {
            return null;
        }

        if (users.getUserId()==null){
            users.setUserId(UUID.randomUUID().toString());
        }

        Boolean allPermissions = false;

        if (userRepository.count()==0){
            allPermissions = true;
        }
        users = setUserAccess(users,allPermissions);
        users.setRole(getRole(users));
        return userRepository.save(users);
    }

    /*
    *
    * Update User
    *
    * */
    @Override
    public Users update(Users users) {
        Users dbUser = findByUserId(users.getUserId());


        if (users.getFirstName()==null){
            users.setFirstName(dbUser.getFirstName());
        }
        if (users.getMiddleName()==null){
            users.setMiddleName(dbUser.getMiddleName());
        }
        if (users.getLastName()==null){
            users.setLastName(dbUser.getLastName());
        }
        if (users.getPassword()==null){
            users.setPassword(dbUser.getPassword());
        }
        if (users.getEmailId()==null){
            users.setEmailId(dbUser.getEmailId());
        }
        if (users.getPhoneNumber()==null){
            users.setPhoneNumber(dbUser.getPhoneNumber());
        }

        //Access
        if (users.getIsSuperAdminAccess() == null){
            users.setIsSuperAdminAccess(dbUser.getIsSuperAdminAccess());
        }
        if (users.getIsAdminAccess() == null) {
            users.setIsAdminAccess(dbUser.getIsAdminAccess());
        }
        if (users.getIsPrincipleAccess() == null) {
            users.setIsPrincipleAccess(dbUser.getIsPrincipleAccess());
        }
        if (users.getIsTeacherAccess() == null) {
            users.setIsTeacherAccess(dbUser.getIsTeacherAccess());
        }
        if (users.getIsStudentAccess() == null) {
            users.setIsStudentAccess(dbUser.getIsStudentAccess());
        }
        if (users.getIsParentAccess() == null) {
            users.setIsParentAccess(dbUser.getIsParentAccess());
        }

        //Login
        if (users.getIsLogin()==null){
            users.setIsLogin(dbUser.getIsLogin());
        }
        users.setRole(getRole(users));
        return userRepository.save(users);
    }

    /*
    *
    * User by Email I'd
    *
    * */
    @Override
    public Users findByEmailId(String email) {
        return userRepository.findByEmailId(email);
    }

    /*
    *
    * Users List by Pagination
    *
    * */
    @Override
    public List<Users> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    /*
    *
    * Users List by Role
    *
    * */
    @Override
    public List<Users> findByRole(String role, Pageable pageable) {
        return userRepository.findByRole(role, pageable);
    }

    /*
    *
    * Users List by First Name
    *
    * */
    @Override
    public List<Users> findByFirstNameContaining(String firstName, Pageable pageable) {
        return userRepository.findByFirstNameContaining(firstName, pageable);
    }

    /*
    *
    * Users List by Middle Name
    *
    * */
    @Override
    public List<Users> findByMiddleNameContaining(String middleName, Pageable pageable) {
        return userRepository.findByMiddleNameContaining(middleName, pageable);
    }

    /*
    *
    * Users List by Last Name
    *
    * */
    @Override
    public List<Users> findByLastNameContaining(String lastName, Pageable pageable) {
        return userRepository.findByLastNameContaining(lastName, pageable);
    }

    /*
    *
    * Users List by First, Middle and Last Name
    *
    * */
    @Override
    public List<Users> findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(String firstName, String middleName, String lastName, Pageable pageable) {
        return userRepository.findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(firstName, middleName, lastName, pageable);
    }

    /*
    *
    * Users List by Phone Number
    *
    * */
    @Override
    public List<Users> findByPhoneNumberContaining(String phoneNumber, Pageable pageable) {
        return userRepository.findByPhoneNumberContaining(phoneNumber, pageable);
    }

    /*
    *
    * Users List of Super Admin Access
    *
    * */
    @Override
    public List<Users> findByIdSuperAdminAccess(boolean isSuperAdmin, Pageable pageable) {
        return userRepository.findByIdSuperAdminAccess(isSuperAdmin, pageable);
    }

    /*
    *
    * Users List of Admin Access
    *
    * */
    @Override
    public List<Users> findByIsAdminAccess(boolean isAdmin, Pageable pageable) {
        return userRepository.findByIsAdminAccess(isAdmin, pageable);
    }

    /*
    *
    * Users List by Principle Access
    *
    * */
    @Override
    public List<Users> findByIsPrincipleAccess(boolean isPrinciple, Pageable pageable) {
        return userRepository.findByIsPrincipleAccess(isPrinciple, pageable);
    }

    /*
    *
    * Users List by Teacher Access
    *
    * */
    @Override
    public List<Users> findByIsTeacherAccess(boolean isTeacher, Pageable pageable) {
        return userRepository.findByIsTeacherAccess(isTeacher, pageable);
    }

    /*
    *
    * Users List by Student Access
    *
    * */
    @Override
    public List<Users> findByIsStudentAccess(boolean isStudent, Pageable pageable) {
        return userRepository.findByIsStudentAccess(isStudent, pageable);
    }

    /*
    *
    * Users List by Parent Access
    *
    * */
    @Override
    public List<Users> findByIsParentAccess(boolean isParent, Pageable pageable) {
        return userRepository.findByIsParentAccess(isParent, pageable);
    }

    /*
    *
    * User by I'd
    *
    * */
    @Override
    public Users findByUserId(String id) {
        return userRepository.findByUserId(id);
    }

    /*
    *
    * User Login Logic
    *
    * */
    @Override
    public Boolean login(Users users) {
        Users dbUser = findByEmailId(users.getEmailId());
        if (dbUser != null) {
            if (dbUser.getPassword().equals(users.getPassword())) {
                dbUser.setIsLogin(true);
                save(dbUser);
                return true;
            }
            return false;
        }
        return null;
    }

    /*
    *
    * User Logout Logic
    *
    * */
    @Override
    public Boolean logout(Users users) {
        Users dbUser = findByEmailId(users.getEmailId());
        if(dbUser.getIsLogin()){
            dbUser.setIsLogin(false);
            save(dbUser);
            return true;
        }
        return false;
    }

    /*
    *
    * Authorization Data
    *
    * */
    public Map<String, Object> authData(Users users){
        Users dbUser;
        Map<String, Object> auth = new HashMap<>();
        synchronized (Users.class){

            dbUser = findByEmailId(users.getEmailId());

            auth.put("userId", dbUser.getUserId());

            if (dbUser.getIsLogin()){
                auth.put("isLogin", true);
            }

            if (dbUser.getIsSuperAdminAccess()){
                auth.put("isSuperAdmin", true);
            }

            if (dbUser.getIsAdminAccess()){
                auth.put("isAdmin", true);
            }

            if (dbUser.getIsPrincipleAccess()){
                auth.put("isPrinciple", true);
            }

            if (dbUser.getIsTeacherAccess()){
                auth.put("isTeacher", true);
            }

            if (dbUser.getIsStudentAccess()){
                auth.put("isStudent", true);
            }

            if (dbUser.getIsParentAccess()){
                auth.put("isParent", true);
            }

        }
        return auth;
    }

}

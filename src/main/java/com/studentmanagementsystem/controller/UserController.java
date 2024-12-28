package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Users;
import com.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public Users save(@RequestBody Users user) {
        return userService.save(user);
    }

    /*
    *
    * Update Existing an User
    *
    * */
    @PutMapping(value = "/update-user/{userId}")
    public Users updateUser(@PathVariable("userId") String userId, @RequestBody Users user) {
        user.setUserId(userId);
        System.out.println(user);
        return userService.update(user);
    }

    /*
    *
    * Get List of User
    *
    * */
    @GetMapping
    public List<Users> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get User List by Role
    *
    * */
    @GetMapping(value = "/role-{role}")
    public List<Users> findByRoleContaining(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize,
            @PathVariable("role") String role
    ) {
        return userService.findByRole(role, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get User List by First-Name
    *
    * */
    @GetMapping(value = "/first-name-{firstName}")
    public List<Users> findByFirstNameContaining(
            @PathVariable("firstName") String firstName,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByFirstNameContaining(firstName, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get User List by Middle-Name
    *
    * */
    @GetMapping(value = "/middle-name-{middleName}")
    public List<Users> findByMiddleNameContaining(
            @PathVariable("middleName") String middleName,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByMiddleNameContaining(middleName, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get User List by Last-Name
    *
    * */
    @GetMapping(value = "/last-name-{lastName}")
    public List<Users> findByLastNameContaining(
            @PathVariable("lastName") String lastName,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByLastNameContaining(lastName, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get User List by First-Name, Middle-Name and Last-Name
    *
    * */
    @GetMapping(value = "/first-name-{firstName}-middle-name-{middleName}-last-name{lastName}")
    public List<Users> findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(
            @PathVariable("firstName") String firstName,
            @PathVariable("middleName") String middleName,
            @PathVariable("lastName") String lastName,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(firstName, middleName, lastName, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get User List by Phone Number
    *
    * */
    @GetMapping(value = "/phone-number-{phoneNumber}")
    public List<Users> findByPhoneNumberContaining(
            @PathVariable("phoneNumber") String phoneNumber,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByPhoneNumberContaining(phoneNumber, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Check User is Super Admin Access
    *
    * */
    @GetMapping(value = "/super-admin-{value}")
    public List<Users> findByIdSuperAdmin(
            @PathVariable("value") boolean isSuperAdmin,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByIdSuperAdminAccess(isSuperAdmin, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Check User is Admin Access
    *
    * */
    @GetMapping(value = "/admin-{value}")
    public List<Users> findByIsAdmin(
            @PathVariable("value") boolean isAdmin,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByIsAdminAccess(isAdmin, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Check User is Principle Access
    *
    * */
    @GetMapping(value = "/principle-{value}")
    public List<Users> findByIsPrinciple(
            @PathVariable("value") boolean isPrinciple,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByIsPrincipleAccess(isPrinciple, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Check User is Teacher Access
    *
    * */
    @GetMapping(value = "/teacher-{value}")
    public List<Users> findByIsTeacher(
            @PathVariable("value") boolean isTeacher,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByIsTeacherAccess(isTeacher, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Check User is Student Access
    *
    * */
    @GetMapping(value = "/student-{value}")
    public List<Users> findByIsStudent(
            @PathVariable("value") boolean isStudent,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByIsStudentAccess(isStudent, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Check User is Parent Access
    *
    * */
    @GetMapping(value = "/parent-{value}")
    public List<Users> findByIsParent(
            @PathVariable("value") boolean isParent,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer pageSize
    ) {
        return userService.findByIsParentAccess(isParent, PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get User by ID
    *
    * */
    @GetMapping(value = "/{id}")
    public Users findByUserId(@PathVariable("id") String id) {
        return userService.findByUserId(id);
    }

    /*
    *
    * User Login
    *
    * */
    @PostMapping(value = "/login-user")
    public Map<String, Object> login(@RequestBody Users users) {
        Map<String, Object> auth = null;
        if (userService.login(users)){
            auth = userService.authData(users);
        }
        return auth;
    }

    /*
    *
    * User Logout
    *
    * */
    @PostMapping(value = "/logout-user")
    public Boolean logout(@RequestBody Users users){
        return userService.logout(users);
    }
}

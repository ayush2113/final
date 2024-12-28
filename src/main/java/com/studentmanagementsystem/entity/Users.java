package com.studentmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String userId;

    private String firstName;

    private String middleName;

    private String lastName;

    @ToString.Exclude
    private String password;

    private String role;

    private String emailId;

    private String phoneNumber;

    @Column(name = "login")
    private Boolean isLogin;

    @Column(name = "superadmin")
    private Boolean isSuperAdminAccess;
    
    @Column(name = "admin")
    private Boolean isAdminAccess;

    @Column(name = "principle")
    private Boolean isPrincipleAccess;

    @Column(name = "teacher")
    private Boolean isTeacherAccess;

    @Column(name = "student")
    private Boolean isStudentAccess;

    @Column(name = "parent")
    private Boolean isParentAccess;

}

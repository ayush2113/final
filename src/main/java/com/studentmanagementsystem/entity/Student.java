package com.studentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @ManyToMany
    @ToString.Exclude
    private List<Classroom> classes = new LinkedList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<Report> reportList = new LinkedList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<Homework> homeworkList = new LinkedList<>();

    @ManyToMany
    @ToString.Exclude
    private List<Parent> parents = new LinkedList<>();

    @ManyToMany
    @ToString.Exclude
    private List<Address> addresses = new LinkedList<>();

    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private School school;
}

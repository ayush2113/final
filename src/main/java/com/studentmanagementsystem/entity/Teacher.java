package com.studentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String gender;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private School schools;

    @OneToMany(mappedBy = "teacher")
    @ToString.Exclude
    private List<Classroom> classroomList = new LinkedList<>();
}

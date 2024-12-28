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
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String principle;

    private String details;

    @ToString.Exclude
    @OneToMany(mappedBy = "schools")
    private List<Teacher> teacherList = new LinkedList<>();

    @ManyToOne
    @ToString.Exclude
    private Address address;

    @ToString.Exclude
    @OneToMany(mappedBy = "school")
    private List<Student> students = new LinkedList<>();
}

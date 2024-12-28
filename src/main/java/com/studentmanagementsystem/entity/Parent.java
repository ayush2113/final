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
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String gender;

    private String firstName;

    private String middleName;

    private String lastName;

    @ManyToMany
    @ToString.Exclude
    private List<Address> address = new LinkedList<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "parents")
    private List<Student> student = new LinkedList<>();
}

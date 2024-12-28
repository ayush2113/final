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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String area;

    private Integer zip;

    private String district;

    private String state;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "address")
    private List<School> school;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "address")
    private List<Parent> parents = new LinkedList<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<Student> students = new LinkedList<>();
}

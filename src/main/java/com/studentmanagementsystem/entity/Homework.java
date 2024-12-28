package com.studentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    private String gradeObtained;

    private String details;

    @Column(name = "date")
    private Date dateCreated;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Student student;
}

package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParentService {
    List<Parent> findAll(Pageable pageable);

    Parent save(Parent parent);

    Parent findById(int id);

    List<Parent> findByFirstNameContaining(String name);

    List<Parent> findByMiddleNameContaining(String name);

    List<Parent> findByLastNameContaining(String name);

    List<Parent> findByFirstNameAndMiddleNameContaining(String firstName, String middleName);

    List<Parent> findByLastNameAndFirstNameContaining(String lastName, String firstName);

    List<Parent> findByFirstNameAndMiddleNameAndLastNameContaining(String firstName, String middleName, String lastName);

}

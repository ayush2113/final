package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClassroomService {
    Classroom save(Classroom classroom);

    Classroom update(int classroomId, Classroom updatedClassroom);

    Classroom findById(int id);

    Classroom findByName(String name);

    Classroom findByCode(String code);

    Page<Classroom> findAll(Pageable pageable);

    Classroom deleteById(int id);

    Classroom deleteByCode(String code);

    Classroom deleteByName(String name);
}

package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.repo.ClassroomRepository;
import com.studentmanagementsystem.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    /*
    *
    * Add Class Room
    *
    * */
    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    /*
    *
    * Update Class Room
    *
    * */
    @Override
    public Classroom update(int classroomId, Classroom updatedClassroom) {
        Classroom classroom = classroomRepository.findById(classroomId);
        if (classroom != null) {
            updatedClassroom.setId(classroomId);
            return save(updatedClassroom);
        }
        return null;
    }

    /*
    *
    * Class Room By I'd
    *
    * */
    @Override
    public Classroom findById(int id) {
        return classroomRepository.findById(id);
    }

    /*
    *
    * Class Room by Class Name
    *
    * */
    @Override
    public Classroom findByName(String name) {
        return classroomRepository.findByName(name);
    }

    /*
    *
    * Class Room by Class Code
    *
    * */
    @Override
    public Classroom findByCode(String code) {
        return classroomRepository.findByCode(code);
    }

    /*
    *
    * Class Room List by Pagination
    *
    * */
    @Override
    public Page<Classroom> findAll(Pageable pageable) {
        return classroomRepository.findAll(pageable);
    }

    /*
    *
    * Delete Class Room by I'd
    *
    * */
    @Override
    public Classroom deleteById(int id) {
        return classroomRepository.deleteById(id);
    }

    /*
    *
    * Delete Class Room By Code
    *
    * */
    @Override
    public Classroom deleteByCode(String code) {
        return classroomRepository.deleteByCode(code);
    }

    /*
    *
    * Delete Class Room By Name
    *
    * */
    @Override
    public Classroom deleteByName(String name) {
        return classroomRepository.deleteByName(name);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init() {
        if (classroomRepository.count() == 0) {
            for (int i = 1; i <= 100; i++) {
                Classroom classroom = new Classroom();

                classroom.setCode(new RandomNameGenerator().next(26, 3));

                classroom.setName(new RandomNameGenerator().next(26, 5));

                classroomRepository.save(classroom);
            }
        }
    }

}

package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Subject;
import com.studentmanagementsystem.repo.SubjectRepository;
import com.studentmanagementsystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    /*
    *
    * Subject by I'd
    *
    * */
    @Override
    public Subject findById(int id) {
        return subjectRepository.findById(id);
    }

    /*
    *
    * Add Subject
    *
    * */
    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    /*
    *
    * Subject List by Name
    *
    * */
    @Override
    public List<Subject> findByNameContaining(String name) {
        return subjectRepository.findByNameContaining(name);
    }

    /*
    *
    * Subject List by Pagination
    *
    * */
    @Override
    public List<Subject> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable).getContent();
    }

    /*
    *
    * Subject List by Name Pagination
    *
    * */
    @Override
    public List<Student> findAllByName(Pageable pageable, String name) {
        return subjectRepository.findAllByName(pageable, name).getContent();
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init() {
        if (subjectRepository.count() == 0) {
            for (int i = 1; i <= 100000; i++) {
                Subject subject = new Subject();

                subject.setName(
                        new RandomNameGenerator().next(26, 8)
                );

                subjectRepository.save(subject);
            }
        }
    }
}

package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Homework;
import com.studentmanagementsystem.repo.HomeworkRepository;
import com.studentmanagementsystem.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkRepository homeworkRepository;

    /*
    *
    * Add Homework
    *
    * */
    @Override
    public Homework save(Homework homework) {
        return homeworkRepository.save(homework);
    }

    /*
    *
    * Update Homework
    *
    * */
    @Override
    public Homework update(int homeworkId, Homework homework) {

        return null;
    }

    /*
    *
    * Homework by I'd
    *
    * */
    @Override
    public Homework findById(int id) {
        return homeworkRepository.findById(id);
    }

    /*
    *
    * Homework List by Pagination
    *
    * */
    @Override
    public Page<Homework> findAll(Pageable pageable) {
        return homeworkRepository.findAll(pageable);
    }

    /*
    *
    * Homework List by Date
    *
    * */
    @Override
    public List<Homework> findByDateCreated(Date date) {
        return homeworkRepository.findByDateCreated(date);
    }

    /*
    *
    * Homework List by Homework Details
    *
    * */
    @Override
    public List<Homework> findByDetailsContaining(String details) {
        return homeworkRepository.findByDetailsContaining(details);
    }

    /*
    *
    * Homework List by Grade Obtained
    *
    * */
    @Override
    public List<Homework> findByGradeObtained(String grade) {
        return homeworkRepository.findByGradeObtained(grade);
    }

    /*
    *
    * Homework List by Grade Obtained List
    *
    * */
    @Override
    public List<Homework> findByGradeObtainedIsIn(List<String> str) {
        return homeworkRepository.findByGradeObtainedIsIn(str);
    }

    /*
    *
    * Homework List by Content
    *
    * */
    @Override
    public List<Homework> findByContentContaining(String content) {
        return homeworkRepository.findByContentContaining(content);
    }

    /*
    *
    * Save all Homework
    *
    * */
    @Override
    public List<Homework> saveAll(List<Homework> list) {
        return homeworkRepository.saveAll(list);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init() {
        if (homeworkRepository.count() == 0) {
            for (int i = 1; i <= 250; i++) {
                Homework homework = new Homework();

                //Random Content
                homework.setContent(new RandomNameGenerator().next(26,100));

                //Random Details
                homework.setDetails(new RandomNameGenerator().next(26,90));

                //Random Grade
                homework.setGradeObtained(new RandomNameGenerator().next(5, 1));

                homework.setDateCreated(new Date());
                homeworkRepository.save(homework);
            }
        }
    }

}

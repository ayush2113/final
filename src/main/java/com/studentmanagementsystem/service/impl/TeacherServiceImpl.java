package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Teacher;
import com.studentmanagementsystem.repo.TeacherRepository;
import com.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    /*
    *
    * Teacher by I'd
    *
    * */
    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id);
    }

    /*
    *
    * Add Teacher
    *
    * */
    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    /*
    *
    * Teacher List by First Name
    *
    * */
    @Override
    public List<Teacher> findByFirstNameContaining(String firstName) {
        return teacherRepository.findByFirstNameContaining(firstName);
    }

    /*
    *
    * Teacher List by Middle Name
    *
    * */
    @Override
    public List<Teacher> findByMiddleNameContaining(String middleName) {
        return teacherRepository.findByMiddleNameContaining(middleName);
    }

    /*
    *
    * Teacher List by Last Name
    *
    * */
    @Override
    public List<Teacher> findByLastNameContaining(String lastName) {
        return teacherRepository.findByLastNameContaining(lastName);
    }

    /*
    *
    * Teacher List by Email I'd
    *
    * */
    @Override
    public List<Teacher> findByEmailContaining(String email) {
        return teacherRepository.findByEmailContaining(email);
    }

    /*
    *
    * Teacher List by Phone Number
    *
    * */
    @Override
    public List<Teacher> findByPhoneNumberContaining(String phoneNumber) {
        return teacherRepository.findByPhoneNumberContaining(phoneNumber);
    }

    /*
    *
    * Teacher List by Gender
    *
    * */
    @Override
    public List<Teacher> findByGenderContaining(String gender) {
        return teacherRepository.findByGenderContaining(gender);
    }

    /*
    *
    * Teacher List by First, Middle and Last Name
    *
    * */
    @Override
    public List<Teacher> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email) {
        return teacherRepository.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    /*
    *
    * Teacher List by Pagination
    *
    * */
    @Override
    public List<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable).getContent();
    }

    /*
    *
    * Delete Teacher by I'd
    *
    * */
    @Override
    public Teacher deleteById(int id) {
        return teacherRepository.deleteById(id);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init(){
        if(teacherRepository.count()==0){
            for (int i = 1; i <= 200000; i++) {
                Teacher teacher = new Teacher();

                teacher.setFirstName(
                        new RandomNameGenerator().next(26, 5)
                );

                teacher.setMiddleName(
                        new RandomNameGenerator().next(26, 5)
                );

                teacher.setLastName(
                        new RandomNameGenerator().next(26, 5)
                );

                teacher.setEmail(
                        new RandomNameGenerator().next(26, 8)
                                        +
                        new RandomNameGenerator().nextIntString(9, 4)
                                        +
                        "@gmail.com"
                );

                teacher.setPhoneNumber(
                        new RandomNameGenerator().nextIntString(9, 10)
                );

                teacher.setGender(
                        new String[]{"Male", "Female"}[new Random().nextInt(2)]
                );

                teacherRepository.save(teacher);
            }
        }

    }
}

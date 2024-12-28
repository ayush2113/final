package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repo.StudentRepository;
import com.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /*
    *
    * Student by I'd
    *
    * */
    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    /*
    *
    * Save Student
    *
    * */
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /*
    *
    * Student by Email I'd
    *
    * */
    @Override
    public Student findByEmailContaining(String email) {
        return studentRepository.findByEmailContaining(email);
    }

    /*
    *
    * Student by Email I'd and School
    *
    * */
    @Override
    public Student findByEmailContaining(String email, int schoolId) {
        return studentRepository.findByEmailContaining(email, schoolId);
    }

    /*
    *
    * Student by Phone Number
    *
    * */
    @Override
    public List<Student> findByPhoneNumber(String mobile) {
        return studentRepository.findByPhoneNumber(mobile);
    }

    /*
    *
    * Student List by First Name
    *
    * */
    @Override
    public List<Student> findByFirstNameContaining(String firstName) {
        return studentRepository.findByFirstNameContaining(firstName);
    }

    /*
    *
    * Student List by Middle Name
    *
    * */
    @Override
    public List<Student> findByMiddleNameContaining(String middleName) {
        return studentRepository.findByMiddleNameContaining(middleName);
    }

    /*
    *
    * Student List by Last Name
    *
    * */
    @Override
    public List<Student> findByLastNameContaining(String lastName) {
        return studentRepository.findByLastNameContaining(lastName);
    }

    /*
    *
    * Student List by First, Middle and Last Name
    *
    * */
    @Override
    public List<Student> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email) {
        return studentRepository.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    /*
    *
    * Student List by Pagination
    *
    * */
    @Override
    public List<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public Student deleteById(int id) {
        return studentRepository.deleteById(id);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init(){
        if(studentRepository.count()==0){
            for (int i = 1; i <= 10000; i++) {
                Student student = new Student();

                student.setEmail(
                        new RandomNameGenerator().next(26,15).toLowerCase()+"@gmail.com"
                );

                student.setFirstName(
                        new RandomNameGenerator().next(26,8)
                );

                student.setMiddleName(
                        new RandomNameGenerator().next(26,8)
                );

                student.setLastName(
                        new RandomNameGenerator().next(26,8)
                );

                student.setPhoneNumber(
                        new RandomNameGenerator().nextIntString(9, 10)
                );

                studentRepository.save(student);
            }
        }
    }
}

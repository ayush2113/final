package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Parent;
import com.studentmanagementsystem.repo.ParentRepository;
import com.studentmanagementsystem.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;

    /*
    *
    * Parent List by Pagination
    *
    * */
    @Override
    public List<Parent> findAll(Pageable pageable) {
        return parentRepository.findAll(pageable).getContent();
    }

    /*
    *
    * Add Parent
    *
    * */
    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    /*
    *
    * Parent by I'd
    *
    * */
    @Override
    public Parent findById(int id) {
        return parentRepository.findById(id);
    }

    /*
    *
    * Parent List by First Name
    *
    * */
    @Override
    public List<Parent> findByFirstNameContaining(String name) {
        return parentRepository.findByFirstNameContaining(name);
    }

    /*
    *
    * Parent List by Middle Name
    *
    * */
    @Override
    public List<Parent> findByMiddleNameContaining(String name) {
        return parentRepository.findByMiddleNameContaining(name);
    }

    /*
    *
    * Parent List by Last Name
    *
    * */
    @Override
    public List<Parent> findByLastNameContaining(String name) {
        return parentRepository.findByLastNameContaining(name);
    }

    /*
    *
    * Parent List by First and Middle Name
    *
    * */
    @Override
    public List<Parent> findByFirstNameAndMiddleNameContaining(String firstName, String middleName) {
        return parentRepository.findByFirstNameAndMiddleNameContaining(firstName, middleName);
    }

    /*
    *
    * Parent List by Last and First Name
    *
    * */
    @Override
    public List<Parent> findByLastNameAndFirstNameContaining(String lastName, String firstName) {
        return parentRepository.findByLastNameAndFirstNameContaining(lastName, firstName);
    }

    /*
    *
    * Parent List by First, Middle and Last Name
    *
    * */
    @Override
    public List<Parent> findByFirstNameAndMiddleNameAndLastNameContaining(String firstName, String middleName, String lastName) {
        return parentRepository.findByFirstNameAndMiddleNameAndLastNameContaining(firstName, middleName, lastName);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init() {
        if (parentRepository.count() == 0) {
            for (int i = 1; i <= 100; i++) {
                Parent parent = new Parent();

                parent.setFirstName(new RandomNameGenerator().next(26,10));

                parent.setMiddleName(new RandomNameGenerator().next(26,10));

                parent.setLastName(new RandomNameGenerator().next(26,10));

                parent.setGender(i%2==0?"male":"female");

                parentRepository.save(parent);
            }
        }
    }

}

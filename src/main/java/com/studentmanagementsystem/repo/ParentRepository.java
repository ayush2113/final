package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Parent;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface ParentRepository extends JpaRepository<Parent, Integer> {
    Page<Parent> findAll(Pageable pageable);

    Parent save(Parent parent);

    Parent findById(int id);

    List<Parent> findByFirstNameContaining(String name);

    List<Parent> findByMiddleNameContaining(String name);

    List<Parent> findByLastNameContaining(String name);

    List<Parent> findByFirstNameAndMiddleNameContaining(String firstName, String middleName);

    List<Parent> findByLastNameAndFirstNameContaining(String lastName, String firstName);

    List<Parent> findByFirstNameAndMiddleNameAndLastNameContaining(String firstName, String middleName, String lastName);

//    @Query(value = "select * from Parent p inner join Address a on ")
//    List<Parent> findByAddressContaining(String address);
}

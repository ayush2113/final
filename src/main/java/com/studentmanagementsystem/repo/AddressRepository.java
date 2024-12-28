package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Address;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address save(Address address);

    Page<Address> findAll(Pageable pageable);

    Address findById(int id);

    List<Address> findByAreaContaining(String area);

    List<Address> findByCityContaining(String city);

    List<Address> findByStateContaining(String state);

    List<Address> findByDistrictContaining(String district);

    List<Address> findByZip(Integer zipcode);

    Address deleteById(int id);
}

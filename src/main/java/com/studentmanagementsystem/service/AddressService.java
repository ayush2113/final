package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Address;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AddressService {
    Address save(Address address);

    List<Address> findAll(Pageable pageable);

    Address findById(int id);

    List<Address> findByAreaContaining(String area);

    List<Address> findByCityContaining(String city);

    List<Address> findByStateContaining(String state);

    List<Address> findByDistrictContaining(String district);

    List<Address> findByZip(Integer zipcode);

    Address deleteById(int id);

    Address updateAddress(int id, Address updatedAddress);

}

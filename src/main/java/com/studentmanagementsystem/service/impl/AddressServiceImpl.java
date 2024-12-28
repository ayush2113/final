package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.repo.AddressRepository;
import com.studentmanagementsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    /*
    *
    * Add Address
    *
    * */
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    /*
    *
    * Address List by Pagination
    *
    * */
    @Override
    public List<Address> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable).getContent();
    }

    /*
    *
    * Address by I'd
    *
    * */
    @Override
    public Address findById(int id) {
        return addressRepository.findById(id);
    }

    /*
    *
    * Address List by District
    *
    * */
    @Override
    public List<Address> findByDistrictContaining(String district) {
        return addressRepository.findByDistrictContaining(district);
    }

    /*
    *
    * Address List by City
    *
    * */
    @Override
    public List<Address> findByCityContaining(String city) {
        return addressRepository.findByCityContaining(city);
    }

    /*
    *
    * Address List by State
    *
    * */
    @Override
    public List<Address> findByStateContaining(String state) {
        return addressRepository.findByStateContaining(state);
    }

    /*
    *
    * Address List by Area
    *
    * */
    @Override
    public List<Address> findByAreaContaining(String area) {
        return addressRepository.findByAreaContaining(area);
    }

    /*
    *
    * Address List by Zip
    *
    * */
    @Override
    public List<Address> findByZip(Integer zipcode) {
        return addressRepository.findByZip(zipcode);
    }

    /*
    *
    * Delete Address by I'd
    *
    * */
    @Override
    public Address deleteById(int id) {
        return addressRepository.deleteById(id);
    }

    /*
    *
    * Update Address
    *
    * */
    @Override
    public Address updateAddress(int id, Address updatedAddress) {
        updatedAddress.setId(id);
        return findById(id)==null? null : addressRepository.save(updatedAddress);
    }

    /*
    *
    * Add Dummy Data
    *
    * */
    public void init() {
        if (addressRepository.count() == 0) {
            for (int i = 1; i <= 50; i++) {
                Address address = new Address();
                address.setZip(new RandomNameGenerator().nextInt(9, 6));
                addressRepository.save(address);
            }
        }
    }

}

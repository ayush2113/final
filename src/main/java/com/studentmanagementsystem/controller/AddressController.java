package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /*
    *
    * Add Address
    *
    * */
    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    /*
    *
    * Get All Address
    *
    * */
    @GetMapping
    public List<Address> getAddress(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ) {
        return addressService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    /*
    *
    * Get Address By ID
    *
    * */
    @GetMapping(value = "/{id}")
    public Address getAddressById(@PathVariable(value = "id") int id) {
        return addressService.findById(id);
    }

    /*
    *
    * Get Address By Area
    *
    * */
    @GetMapping(value = "/area-{area}")
    public List<Address> getAddressByArea(@PathVariable("area") String area) {
        return addressService.findByAreaContaining(area);
    }

    /*
    *
    * Get Address By City
    *
    * */
    @GetMapping(value = "/city-{city}")
    public List<Address> getAddressByCity(@PathVariable("city") String city) {
        return addressService.findByCityContaining(city);
    }

    /*
    *
    * Get Address by State
    *
    * */
    @GetMapping(value = "/state-{state}")
    public List<Address> getAddressByState(@PathVariable("state") String state) {
        return addressService.findByStateContaining(state);
    }

    /*
    *
    * Get Address by District
    *
    * */
    @GetMapping(value = "/district-{district}")
    public List<Address> getAddressByDistrict(@PathVariable("district") String district) {
        return addressService.findByDistrictContaining(district);
    }

    /*
    *
    * Get Address by Zip-Code
    *
    * */
    @GetMapping(value = "/zip-{zip}")
    public List<Address> getAddressByZip(@PathVariable("zip") Integer zip) {
        return addressService.findByZip(zip);
    }

    /*
    *
    * Delete Address by ID
    *
    * */
    @DeleteMapping(value = "/{id}")
    public Object deleteAddressById(@PathVariable("id") int id) {
        return addressService.deleteById(id);
    }

    /*
    *
    * Save All Address At Once
    *
    * */
    @PostMapping(value = "/save-all-address")
    public List<Address> saveAll(@RequestBody List<Address> addresses) {
        for (Address address : addresses) {
            addressService.save(address);
        }
        return addresses;
    }

    /*
    *
    * Update Address By ID
    *
    * */
    @PutMapping("/{id}")
    public Object updateAddress(@PathVariable("id") int id, @RequestBody Address updatedAddress) {
        Address address = addressService.updateAddress(id,updatedAddress);
        return address==null? "Address Not Found": address;
    }


    /*
    *
    * Find By Any
    *
    * */
    @GetMapping("/search")
    public Object getAddresses(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize,

            @RequestParam(value = "area", required = false) String area,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "district", required = false) String district,
            @RequestParam(value = "pincode", required = false) Integer pinCode,
            @RequestParam(value = "id", required = false) Integer id

    ) {
        if (area!=null){
            return this.getAddressByArea(area);
        } else if (city!=null) {
            return this.getAddressByCity(city);
        }else if (state!=null) {
            return this.getAddressByState(state);
        }else if (district!=null) {
            return this.getAddressByDistrict(district);
        }else if (pinCode!=null && pinCode!=0) {
            return this.getAddressByZip(pinCode);
        }else if (id!=null && id!=0) {
            return this.getAddressById(id);
        }

        return getAddress(pageNumber, pageSize);
    }

}

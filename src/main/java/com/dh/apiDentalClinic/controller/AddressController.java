package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

public class AddressController {
    private AddressServiceImpl addressServiceimpl;

    @Autowired
    public AddressController(AddressServiceImpl addressServiceimpl) {
        this.addressServiceimpl = addressServiceimpl;
    }


    @GetMapping()
    public Set<Address> getAllAddress() {
        return addressServiceimpl.findAllAddress();
    }

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressServiceimpl.saveAddress(address);
    }
}

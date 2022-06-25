package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.repository.IAddressRepository;
import com.dh.apiDentalClinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements IAddressService {

    private IAddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Set<Address> findAllAddress() {
        return (Set<Address>) addressRepository.findAll();
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address saveAddress(Address newAddress) {
        if (newAddress != null) {
            return addressRepository.save(newAddress);
        }
        return new Address();
    }

    @Override
    public String deleteAddress(Long id) {
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
            return "Address with id " + id + " delete";
        }
        return "Address with id " + id + "dont exist";
    }


    @Override
    public String updateAddress(Address newAddress) {
        return null;
    }
}

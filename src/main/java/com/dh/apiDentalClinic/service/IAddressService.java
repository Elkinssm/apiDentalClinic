package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IAddressService {

    Set<Address> findAllAddress();

    Optional<Address> findAddressById(Long id);

    Address saveAddress(Address newAddress);

    String deleteAddress(Long id);

    String updateAddress(Address newAddress);
}

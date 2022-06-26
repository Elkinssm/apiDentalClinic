package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.repository.IAddressRepository;
import com.dh.apiDentalClinic.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(AddressDTO addressDTO) {
        Address address = mapper.convertValue(addressDTO, Address.class);
        addressRepository.save(address);
    }

    @Override
    public Collection<AddressDTO> findAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        Set<AddressDTO> addressDTO = new HashSet<>();
        for (Address address : addresses) {
            addressDTO.add(mapper.convertValue(address, AddressDTO.class));
        }
        return addressDTO;
    }

    @Override
    public Optional<AddressDTO> findAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        AddressDTO addressDTO = null;
        if (address.isPresent()) {
            addressDTO = mapper.convertValue(address, AddressDTO.class);
        }
        return Optional.ofNullable(addressDTO);
    }

    @Override
    public void saveAdrress(AddressDTO newAddressDTO) {
        saveMethod(newAddressDTO);
    }

    @Override
    public void deleteAdrress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void updateAdrress(AddressDTO newAddressDTO) {
        saveMethod(newAddressDTO);
    }
}

package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.AddressDTO;

import java.util.Collection;


public interface IAddressService {

    Collection<AddressDTO> findAllAddress();

    AddressDTO findAddressById(Long id);

    void saveAdrress(AddressDTO newAddressDTO);

    void deleteAdrress(Long id);

    void updateAdrress(AddressDTO newAddressDTO);
}

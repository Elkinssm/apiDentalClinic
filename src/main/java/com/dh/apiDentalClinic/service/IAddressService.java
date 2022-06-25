package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.entity.Turn;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IAddressService {

    Set<AddressDTO> findAllAddress();

    Optional<AddressDTO> findAddressById(Long id);

    void saveTurn(AddressDTO newAddressDTO);

    void deleteTurn(Long id);

    void updateTurn(AddressDTO newAddressDTO);
}

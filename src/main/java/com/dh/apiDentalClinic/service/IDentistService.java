package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.DentistDTO;

import java.util.Collection;


public interface IDentistService {

    Collection<DentistDTO> findAllDentist();
    DentistDTO findDentistById(Long id);

    void saveDentist(DentistDTO newDentistDTO);

    void deleteDentist(Long id);

    void updateDentist(DentistDTO newDentistDTO);
}

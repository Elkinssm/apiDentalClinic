package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IPatientService {

    Set<PatientDTO> findAllPatients();

    Optional<PatientDTO> findPatientById(Long id);

    void savePatient(PatientDTO newPatientDTO);

    void deleteTurn(Long id);

    void updateTurn(PatientDTO newPatientDTO);
}

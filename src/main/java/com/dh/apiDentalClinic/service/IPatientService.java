package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


public interface IPatientService {

    Set<PatientDTO> findAllPatients();

    Optional<PatientDTO> findPatientById(Long id);

    void savePatient(PatientDTO newPatientDTO);

    void deletePatient(Long id);

    void updatePatient(PatientDTO newPatientDTO);
}

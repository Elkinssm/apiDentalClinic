package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IPatientService {

    Set<Patient> findAllPatients();

    Optional<Patient> findPatientById(Long id);

    Patient savePatient(Patient newPatient);

    String deletePatient(Long id);

    String updatePatient(Patient newPatient);
}

package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.repository.IAddressRepository;
import com.dh.apiDentalClinic.repository.IPatientRepository;
import com.dh.apiDentalClinic.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements IPatientService {

    private IPatientRepository patientRepository;
    private IAddressRepository addressRepository;

    @Autowired
    public PatientServiceImpl(IPatientRepository iPatientRepository, IAddressRepository iaddressRepository) {
        this.patientRepository = iPatientRepository;
        this.addressRepository = iaddressRepository;
    }


    @Override
    public Set<Patient> findAllPatients() {
        return (Set<Patient>) patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient savePatient(Patient newPatient) {
        if (newPatient != null) {
            return patientRepository.save(newPatient);
        }
        return new Patient();
    }

    @Override
    public String deletePatient(Long id) {
        if (patientRepository.findById(id).isPresent()) {
            patientRepository.deleteById(id);
            return "Patient with id " + id + " delete";
        }
        return "Patient with id " + id + "dont exist";
    }

    @Override
    public String updatePatient(Patient newPatient) {
        return null;
    }
}

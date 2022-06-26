package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.DTO.PatientDTO;
import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.repository.IAddressRepository;
import com.dh.apiDentalClinic.repository.IPatientRepository;
import com.dh.apiDentalClinic.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(PatientDTO patientDTO) {
        AddressDTO addressdto = patientDTO.getAddress();
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        patient.setAddress(null);
        patientRepository.save(patient);
        Address address = mapper.convertValue(addressdto, Address.class);
        address.setId(patient.getId());
        addressRepository.save(address);

    }


    @Override
    public Collection<PatientDTO> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientsDTO = new HashSet<>();


        //List<PatientDTO> patientDto= mapper.convertValue (<List<Patient> , List< PatientDTO.class>>(patients))

        for (Patient patient : patients) {
            Optional<Address> addressOptional = addressRepository.findById(patient.getId());
//            if (addressOptional.isPresent()) {
//                patient.setAddress(addressOptional.get());
//            }
            addressOptional.ifPresent(patient::setAddress);

            patientsDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientsDTO;

    }

    @Override
    public Optional<PatientDTO> findPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if (patient.isPresent()) {
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        }
        return Optional.ofNullable(patientDTO);
    }

    @Override
    public void savePatient(PatientDTO newPatientDTO) {
        saveMethod(newPatientDTO);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void updatePatient(PatientDTO newPatientDTO) {
        saveMethod(newPatientDTO);
    }
}

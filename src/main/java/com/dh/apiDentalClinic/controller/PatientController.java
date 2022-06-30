package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.DTO.PatientDTO;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.service.IAddressService;
import com.dh.apiDentalClinic.service.IPatientService;
import com.dh.apiDentalClinic.service.impl.PatientServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @GetMapping("/all")
    public Collection<PatientDTO> getAllPatients() {
        return patientService.findAllPatients();

    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable Long id) {
        return patientService.findPatientById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> savePatient(@RequestBody PatientDTO patientDTO) {
        patientService.savePatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        patientService.updatePatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}

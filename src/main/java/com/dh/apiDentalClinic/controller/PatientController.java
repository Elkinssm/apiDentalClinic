package com.dh.apiDentalClinic.controller;


import com.dh.apiDentalClinic.DTO.PatientDTO;
import com.dh.apiDentalClinic.service.IPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<Collection<PatientDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.findAllPatients(),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id) {
        PatientDTO patientDTO = patientService.findPatientById(id);
        return new ResponseEntity<>(patientDTO,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping("/add")
    public ResponseEntity<?> savePatient(@RequestBody PatientDTO patientDTO) {
        patientService.savePatient(patientDTO);
        return new ResponseEntity<>("Patient added successfully!!",HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<String> response;
        if (patientService.findPatientById(patientDTO.getId()) != null) {
            patientService.updatePatient(patientDTO);
            response=new ResponseEntity<>("Update patient",HttpStatus.CREATED);
        } else {
            response= new ResponseEntity<>("Failed to update address, check sent values and id",HttpStatus.BAD_REQUEST);
        }
        return response;

    }

    @PreAuthorize("hasRole('ADMIN') ")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (patientService.findPatientById(id) != null) {
            patientService.deletePatient(id);
            response = new ResponseEntity<>("Deleted patient with id: " + id,HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("It is not find the patient with the id: " + id,HttpStatus.NOT_FOUND);
        }

        return response;
    }

}

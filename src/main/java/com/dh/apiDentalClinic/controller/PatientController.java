package com.dh.apiDentalClinic.controller;


import com.dh.apiDentalClinic.DTO.PatientDTO;
import com.dh.apiDentalClinic.service.IPatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Patients", description = "Operations related to patients")
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<Collection<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id) {
        PatientDTO patientDTO = patientService.findPatientById(id);
        return ResponseEntity.ok(patientDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<?> savePatient(@RequestBody PatientDTO patientDTO) {
        patientService.savePatient(patientDTO);
        return ResponseEntity.ok("Patient added successfully!!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<String> response;
        if (patientService.findPatientById(patientDTO.getId()) != null) {
            patientService.updatePatient(patientDTO);
            response= ResponseEntity.ok("Update patient");
        } else {
            response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (patientService.findPatientById(id) != null) {
            patientService.deletePatient(id);
            response = ResponseEntity.ok("Deleted patient with id: " + id);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }

}

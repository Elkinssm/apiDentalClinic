package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientServiceImpl patientServiceimpl;

    @Autowired
    public PatientController(PatientServiceImpl patientServiceimpl) {
        this.patientServiceimpl = patientServiceimpl;
    }

    @GetMapping()
    public Set<Patient> getAllPatients() {
        return patientServiceimpl.findAllPatients();
    }

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientServiceimpl.savePatient(patient);
    }
}

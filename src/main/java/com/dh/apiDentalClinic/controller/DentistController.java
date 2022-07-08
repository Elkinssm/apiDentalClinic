package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.DentistDTO;
import com.dh.apiDentalClinic.service.IDentistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RequestMapping("/dentist")
@RestController
public class DentistController {
    @Autowired
    IDentistService iDentistService;

    @GetMapping("/all")
    public ResponseEntity<Collection<DentistDTO>> getAllTurn() {
        return ResponseEntity.ok(iDentistService.findAllDentist());
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getDentist(@PathVariable Long id) {
        DentistDTO dentistDTO = iDentistService.findDentistById(id);
        return ResponseEntity.ok(dentistDTO);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> saveDentist(@RequestBody DentistDTO dentistDTO) {
        iDentistService.saveDentist(dentistDTO);
        return ResponseEntity.ok("Dentist created successfully!!");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO) {
        ResponseEntity<String> response;
        if (iDentistService.findDentistById(dentistDTO.getId()) != null) {
            iDentistService.updateDentist(dentistDTO);
            response = ResponseEntity.ok("Update dentist");
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (iDentistService.findDentistById(id) != null) {
            iDentistService.deleteDentist(id);
            response = ResponseEntity.ok("Deleted dentist with id: " + id);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}

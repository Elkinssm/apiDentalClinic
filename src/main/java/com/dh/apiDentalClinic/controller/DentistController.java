package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.DentistDTO;
import com.dh.apiDentalClinic.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/dentist")
@RestController
public class DentistController {
    @Autowired
    IDentistService iDentistService;

    @GetMapping("/all")
    public Collection<DentistDTO> getAllTurn() {
        return iDentistService.findAllDentist();
    }

    @GetMapping("/{id}")
    public Optional<DentistDTO> getDentist(@PathVariable Long id) {
        return iDentistService.findDentistById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveDentist(@RequestBody DentistDTO dentistDTO) {
        iDentistService.saveDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO) {
        iDentistService.updateDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) {
        iDentistService.deleteDentist(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}

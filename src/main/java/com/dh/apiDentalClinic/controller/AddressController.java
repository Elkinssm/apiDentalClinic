package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/address")
@RestController
public class AddressController {
@Autowired
    IAddressService addressService;

    @GetMapping("/all")
    public Collection<AddressDTO> getAllAddress() {
        return addressService.findAllAddress();
    }

    @GetMapping("/{id}")
    public Optional<AddressDTO> getAddress(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveAddress(@RequestBody AddressDTO addressDTO) {
        addressService.saveAdrress(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO) {
        addressService.updateAdrress(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        addressService.deleteAdrress(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RequestMapping("/address")
@RestController
public class AddressController {
    @Autowired
    IAddressService addressService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<Collection<AddressDTO>> getAllAddress() {

        return new ResponseEntity<>(addressService.findAllAddress(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getAddress(@PathVariable Long id) {
        AddressDTO addressDTO = addressService.findAddressById(id);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> saveAddress(@RequestBody AddressDTO addressDTO) {
        addressService.saveAdrress(addressDTO);
        return new ResponseEntity<>("Address created successfully!!",HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO) {
        ResponseEntity<String> response;
        if (addressService.findAddressById(addressDTO.getId()) != null) {
            addressService.updateAdrress(addressDTO);
            response = new ResponseEntity<>("Update address", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("Failed to update address, check sent values and id",HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (addressService.findAddressById(id) != null) {
            addressService.deleteAdrress(id);
            response = ResponseEntity.ok("Deleted address with id: " + id);
        } else {
            response = new ResponseEntity<>("It is not find the address with the id: " + id, HttpStatus.NOT_FOUND);
        }

        return response;
    }
}

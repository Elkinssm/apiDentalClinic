package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.service.IAddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Address", description = "Operations related to address")
@RequestMapping("/address")
@RestController
public class AddressController {
    @Autowired
    IAddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<Collection<AddressDTO>> getAllAddress() {

        return ResponseEntity.ok(addressService.findAllAddress());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddress(@PathVariable Long id) {
        AddressDTO addressDTO = addressService.findAddressById(id);
        return ResponseEntity.ok(addressDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveAddress(@RequestBody AddressDTO addressDTO) {
        addressService.saveAdrress(addressDTO);
        return ResponseEntity.ok("Address created successfully!!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO) {
        ResponseEntity<String> response;
        if (addressService.findAddressById(addressDTO.getId()) != null) {
            addressService.updateAdrress(addressDTO);
            response = ResponseEntity.ok("Update address");
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (addressService.findAddressById(id) != null) {
            addressService.deleteAdrress(id);
            response = ResponseEntity.ok("Deleted address with id: " + id);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}

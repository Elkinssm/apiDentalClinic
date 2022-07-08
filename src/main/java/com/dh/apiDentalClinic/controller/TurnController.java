package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.DTO.TurnResponseDTO;
import com.dh.apiDentalClinic.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RequestMapping("/turn")
@RestController
public class TurnController {
    @Autowired
    ITurnService iTurnService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/all")
    public ResponseEntity<Collection<TurnResponseDTO>> getAllTurn() {
        return new ResponseEntity<>(iTurnService.findAllTurns(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getTurn(@PathVariable Long id) {
        TurnDTO turnDTO = iTurnService.findTurnById(id);
        return new ResponseEntity<>(turnDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping("/add")
    public ResponseEntity<?> saveTurn(@RequestBody TurnDTO turnDTO) {
        iTurnService.saveTurn(turnDTO);
        return new ResponseEntity<>("Turn created successfully!!", HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("/update")
    public ResponseEntity<?> updateTurn(@RequestBody TurnDTO turnDTO) {
        ResponseEntity<String> response;
        if (iTurnService.findTurnById(turnDTO.getId()) != null) {
            iTurnService.updateTurn(turnDTO);
            response = new ResponseEntity<>("Update shift", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Failed to update shift, check sent values and id", HttpStatus.BAD_REQUEST);

        }
        return response;
    }

    @PreAuthorize("hasRole('ADMIN') ")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (iTurnService.findTurnById(id) != null) {
            iTurnService.deleteTurn(id);
            response = new ResponseEntity<>("Deleted shift with id: " + id, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("It is not find the turn with the id:" + id, HttpStatus.NOT_FOUND);
        }

        return response;
    }
}

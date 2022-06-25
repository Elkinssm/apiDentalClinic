package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.service.ITurnService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/turn")
@RestController
public class TurnController {
    @Autowired
    ITurnService iTurnService;

    @GetMapping("/all")
    public Collection<TurnDTO> getAllTurn() {
        return iTurnService.findAllTurns();
    }

    @GetMapping("/{id}")
    public Optional<TurnDTO> getTurn(@PathVariable Long id) {
        return iTurnService.findTurnById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveTurn(@RequestBody TurnDTO turnDTO) {
        iTurnService.saveTurn(turnDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTurn(@RequestBody TurnDTO turnDTO) {
        iTurnService.updateTurn(turnDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) {
        iTurnService.deleteTurn(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

package com.dh.apiDentalClinic.controller;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.DTO.TurnResponseDTO;
import com.dh.apiDentalClinic.service.ITurnService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Turn", description = "Operations related to turns")
@RequestMapping("/turn")
@RestController
public class TurnController {
    @Autowired
    ITurnService iTurnService;

    @GetMapping("/all")
    public ResponseEntity<Collection<TurnResponseDTO>> getAllTurn() {
        return ResponseEntity.ok(iTurnService.findAllTurns());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTurn(@PathVariable Long id) {
        TurnDTO turnDTO = iTurnService.findTurnById(id);
        return ResponseEntity.ok(turnDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveTurn(@RequestBody TurnDTO turnDTO) {
        iTurnService.saveTurn(turnDTO);
        return ResponseEntity.ok("Shift created successfully!!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTurn(@RequestBody TurnDTO turnDTO) {
        ResponseEntity<String> response;
        if (iTurnService.findTurnById(turnDTO.getId()) != null) {
            iTurnService.updateTurn(turnDTO);
            response = ResponseEntity.ok("Update shift");
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (iTurnService.findTurnById(id) != null) {
            iTurnService.deleteTurn(id);
            response = ResponseEntity.ok("Deleted shift with id: " + id);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}

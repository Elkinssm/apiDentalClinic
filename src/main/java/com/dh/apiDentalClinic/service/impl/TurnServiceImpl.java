package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.PatientDTO;
import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.entity.Turn;
import com.dh.apiDentalClinic.repository.IPatientRepository;
import com.dh.apiDentalClinic.repository.ITurnRepository;
import com.dh.apiDentalClinic.service.ITurnService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnServiceImpl implements ITurnService {

    @Autowired
    private ITurnRepository turnRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(TurnDTO turnDTO) {
        Turn turn = mapper.convertValue(turnDTO, Turn.class);
        turnRepository.save(turn);
    }
    @Override
    public Set<TurnDTO> findAllTurns() {
        List<Turn> turns = turnRepository.findAll();
        Set<TurnDTO> turnDTO = new HashSet<>();

        for (Turn turn : turns) {
            turnDTO.add(mapper.convertValue(turns, TurnDTO.class));
        }
        return turnDTO;

    }

    @Override
    public Optional<TurnDTO> findTurnById(Long id) {
        Optional<Turn> turn = turnRepository.findById(id);
        TurnDTO turnDTO = null;
        if (turn.isPresent()) {
            turnDTO = mapper.convertValue(turn, TurnDTO.class);
        }
        return Optional.ofNullable(turnDTO);
    }

    @Override
    public void saveTurn(TurnDTO newTurnDTO) {
        saveMethod(newTurnDTO);
    }

    @Override
    public void deleteTurn(Long id) {
        turnRepository.deleteById(id);
    }

    @Override
    public void updateTurn(TurnDTO newTurnDTO) {
        saveMethod(newTurnDTO);
    }
}

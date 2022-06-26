package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.DTO.TurnResponseDTO;
import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.entity.Turn;
import com.dh.apiDentalClinic.repository.IDentistRepository;
import com.dh.apiDentalClinic.repository.IPatientRepository;
import com.dh.apiDentalClinic.repository.ITurnRepository;
import com.dh.apiDentalClinic.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnServiceImpl implements ITurnService {

    @Autowired
    private ITurnRepository turnRepository;
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(TurnDTO turnDTO) {
        Optional<Dentist> dentistOptional = dentistRepository.findById(turnDTO.getDentist_id());
        Optional<Patient> patientOptional = patientRepository.findById(turnDTO.getPatient_id());
        Turn turn = mapper.convertValue(turnDTO, Turn.class);
        patientOptional.ifPresent(turn::setPatient);
        dentistOptional.ifPresent(turn::setDentist);
        turnRepository.save(turn);
    }

    @Override
    public Collection<TurnResponseDTO> findAllTurns() {
        List<Turn> turns = turnRepository.findAll();
        Set<TurnResponseDTO> turnResponseDTO = new HashSet<>();

        for (Turn turn : turns) {
            Long patientId = turn.getPatient().getId();
            Optional<Patient> patientOptional = patientRepository.findById(turn.getPatient().getId());
            Optional<Dentist> dentistOptional = dentistRepository.findById(turn.getDentist().getId());

            patientOptional.ifPresent(turn::setPatient);
            dentistOptional.ifPresent(turn::setDentist);
            turnResponseDTO.add(mapper.convertValue(turn, TurnResponseDTO.class));
        }
        return turnResponseDTO;

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

package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.DTO.TurnResponseDTO;
import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.entity.Turn;
import com.dh.apiDentalClinic.exception.ResourceNotFoundException;
import com.dh.apiDentalClinic.repository.IAddressRepository;
import com.dh.apiDentalClinic.repository.IDentistRepository;
import com.dh.apiDentalClinic.repository.IPatientRepository;
import com.dh.apiDentalClinic.repository.ITurnRepository;
import com.dh.apiDentalClinic.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnServiceImpl implements ITurnService {

    @Autowired
    private ITurnRepository turnRepository;
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(TurnDTO turnDTO) {
        Dentist dentist = dentistRepository.findById(turnDTO.getDentist_id()).orElseThrow();
        Patient patient = patientRepository.findById(turnDTO.getPatient_id()).orElseThrow();
        Turn turn = mapper.convertValue(turnDTO, Turn.class);
        //  addressRepository.save(address);
        if (dentist != null) {
            turn.setDentist(dentist);
        }
        if (patient != null) {
            turn.setPatient(patient);
        } else {
            throw new ResourceNotFoundException("Turn", "id","id not found: " + turnDTO.getId());
        }

        turnRepository.save(turn);


    }

    @Override
    public Collection<TurnResponseDTO> findAllTurns() {
        List<Turn> turns = turnRepository.findAll();
        Set<TurnResponseDTO> turnResponseDTO = new HashSet<>();


        for (Turn turn : turns) {
            Long patientId = turn.getPatient().getId();
            Patient patient = patientRepository.findById(turn.getPatient().getId()).orElseThrow(() -> new ResourceNotFoundException("Patient", "Id","id not found: " + patientId));
            Dentist dentist = dentistRepository.findById(turn.getDentist().getId()).orElseThrow(() -> new ResourceNotFoundException("Dentist", "Id", "id not found: " +patientId));
            Address address = addressRepository.findById(patient.getId()).orElseThrow(() -> new ResourceNotFoundException("Address", "Id", "id not found: " +patientId));

            if (patient != null) {
                patient.setAddress(address);
                turn.setPatient(patient);
            }

            if (dentist != null) {
                turn.setDentist(dentist);
            }

            if (patient.getAddress() != null) {
                turn.setPatient(patient);
            }
//
            turnResponseDTO.add(mapper.convertValue(turn, TurnResponseDTO.class));
        }
        return turnResponseDTO;

    }

    @Override
    public TurnDTO findTurnById(Long id) {
        Turn turn = turnRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turn", "Id", "id not found: " + id));
        TurnDTO turnDTO = null;
        turnDTO = mapper.convertValue(turn, TurnDTO.class);
        return turnDTO;
    }

    @Override
    public void saveTurn(TurnDTO newTurnDTO) {

        saveMethod(newTurnDTO);
    }

    @Override
    public void deleteTurn(Long id) {
        Turn turn = turnRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turn", "id", "id not found: " +id));
        turnRepository.deleteById(id);
    }

    @Override
    public void updateTurn(TurnDTO newTurnDTO) {
        saveMethod(newTurnDTO);
    }
}

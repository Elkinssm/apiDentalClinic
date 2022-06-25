package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.entity.Turn;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ITurnService {

    Set<Turn> findAllTurns();

    Optional<Patient> findTurnsById(Long id);

    Turn savePatient(Turn newTurn);

    String deleteTurn(Long id);

    String updateTurn(Turn newTurn);

}

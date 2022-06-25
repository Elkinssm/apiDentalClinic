package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.entity.Turn;
import com.dh.apiDentalClinic.service.ITurnService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class TurnServiceImpl implements ITurnService {
    @Override
    public Set<Turn> findAllTurns() {
        return null;
    }

    @Override
    public Optional<Patient> findTurnsById(Long id) {
        return Optional.empty();
    }

    @Override
    public Turn savePatient(Turn newTurn) {
        return null;
    }

    @Override
    public String deleteTurn(Long id) {
        return null;
    }

    @Override
    public String updateTurn(Turn newTurn) {
        return null;
    }
}

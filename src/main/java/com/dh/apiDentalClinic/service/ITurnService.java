package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ITurnService {

    Set<TurnDTO> findAllTurns();

    Optional<TurnDTO> findTurnById(Long id);

    void saveTurn(TurnDTO newTurnDTO);

    void deleteTurn(Long id);

    void updateTurn(TurnDTO newTurnDTO);

}

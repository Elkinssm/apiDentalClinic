package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.DTO.TurnResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;


public interface ITurnService {

    Collection<TurnResponseDTO> findAllTurns();

    Optional<TurnDTO> findTurnById(Long id);

    void saveTurn(TurnDTO newTurnDTO);

    void deleteTurn(Long id);

    void updateTurn(TurnDTO newTurnDTO);

}

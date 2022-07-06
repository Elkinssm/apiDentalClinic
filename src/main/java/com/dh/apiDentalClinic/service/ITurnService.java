package com.dh.apiDentalClinic.service;


import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.DTO.TurnResponseDTO;

import java.util.Set;


public interface ITurnService {

    Set<TurnResponseDTO> findAllTurns();

    TurnDTO findTurnById(Long id);

    void saveTurn(TurnDTO newTurnDTO);

    void deleteTurn(Long id);

    void updateTurn(TurnDTO newTurnDTO);

}

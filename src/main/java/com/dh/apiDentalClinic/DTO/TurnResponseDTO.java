package com.dh.apiDentalClinic.DTO;

import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.entity.Patient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TurnResponseDTO {
    private Long id;
    private Dentist dentist;
    private Patient patient;
    private String date;
}

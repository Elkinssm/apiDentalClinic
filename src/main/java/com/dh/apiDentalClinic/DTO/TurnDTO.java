package com.dh.apiDentalClinic.DTO;

import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurnDTO {
    private Long id;
    private Dentist dentist;
    private Patient patient;
    private LocalDate date;
}

package com.dh.apiDentalClinic.DTO;

import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class TurnDTO {
    private Long id;
    private Long dentist_id;
    private Long patient_id;
//    private Dentist dentist;
//    private Patient patient;
    private String date;
}

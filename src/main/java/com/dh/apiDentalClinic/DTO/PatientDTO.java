package com.dh.apiDentalClinic.DTO;

import com.dh.apiDentalClinic.entity.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class PatientDTO {

    private Long id;
    private String name;
    private String lastName;
    private String DNI;
    //@JsonFormat(pattern = "dd-MM-yyyy")
    private String admissionsDate;
    private AddressDTO address;

}

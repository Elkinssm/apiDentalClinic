package com.dh.apiDentalClinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
@Table(name = "turns")

@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})

public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id",referencedColumnName = "id")
    private Dentist dentist;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;


    private String date;

    private Long dentista;
    private Long paciente;
}

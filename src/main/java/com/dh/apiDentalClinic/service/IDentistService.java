package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.entity.Dentist;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IDentistService {

    Set<Dentist> findAllDentists();

    Optional<Dentist> findDentistById(Long id);

    Dentist saveDentist(Dentist newDentist);

    String deleteDentist(Long id);

    String updateDentist(Dentist newDentist);
}

package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.service.IDentistService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class DentistServiceImpl implements IDentistService {
    @Override
    public Set<Dentist> findAllDentists() {
        return null;
    }

    @Override
    public Optional<Dentist> findDentistById(Long id) {
        return Optional.empty();
    }

    @Override
    public Dentist saveDentist(Dentist newDentist) {
        return null;
    }

    @Override
    public String deleteDentist(Long id) {
        return null;
    }

    @Override
    public String updateDentist(Dentist newDentist) {
        return null;
    }
}

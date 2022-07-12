package com.dh.apiDentalClinic.service.security;

import com.dh.apiDentalClinic.entity.login.Rol;
import com.dh.apiDentalClinic.entity.login.enums.RolName;
import com.dh.apiDentalClinic.repository.login.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRoleRepository roleRepository;

    public Optional<Rol> getByRolName(RolName rolName){
        return roleRepository.findByRolName(rolName);
    }
}

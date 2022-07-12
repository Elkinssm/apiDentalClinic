package com.dh.apiDentalClinic.repository.login;

import com.dh.apiDentalClinic.entity.login.Rol;
import com.dh.apiDentalClinic.entity.login.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Rol, Long> {


    Optional<Rol> findByRolName(RolName rolName);


}

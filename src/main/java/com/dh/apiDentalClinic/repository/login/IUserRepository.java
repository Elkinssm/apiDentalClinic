package com.dh.apiDentalClinic.repository.login;

import com.dh.apiDentalClinic.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository

public interface IUserRepository extends JpaRepository<User, Long> {

     Optional<User> findByEmail(String email);

     Optional<User> findByUserName(String userName);

     Boolean existsByUserName(String userName);

     Boolean existsByEmail(String email);

}

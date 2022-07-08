package com.dh.apiDentalClinic.security.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RegisterDTO {

    private String name;

    private String userName;

    private String email;

    private String password;
    private Set<String> roles = new HashSet<>();
}

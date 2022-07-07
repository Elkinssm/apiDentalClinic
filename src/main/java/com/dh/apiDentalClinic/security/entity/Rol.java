package com.dh.apiDentalClinic.security.entity;

import com.dh.apiDentalClinic.security.enums.NameRol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private NameRol nameRol;

    public Rol() {
    }

    public Rol(NameRol nameRol) {
        this.nameRol = nameRol;
    }
}

package com.dh.apiDentalClinic.DTO.loginDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class LoginDTO {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}

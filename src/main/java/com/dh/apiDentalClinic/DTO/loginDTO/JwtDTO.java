package com.dh.apiDentalClinic.DTO.loginDTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String nameUser;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String nameUser, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nameUser = nameUser;
        this.authorities = authorities;
    }
}

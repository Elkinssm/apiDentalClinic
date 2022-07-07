package com.dh.apiDentalClinic.security.controller;

import com.dh.apiDentalClinic.security.entity.DTO.JwtDTO;
import com.dh.apiDentalClinic.security.entity.DTO.LoginDTO;
import com.dh.apiDentalClinic.security.entity.DTO.RegisterDTO;
import com.dh.apiDentalClinic.security.entity.Rol;
import com.dh.apiDentalClinic.security.entity.User;
import com.dh.apiDentalClinic.security.enums.NameRol;
import com.dh.apiDentalClinic.security.jwt.JwtProvider;
import com.dh.apiDentalClinic.security.service.RolService;
import com.dh.apiDentalClinic.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody RegisterDTO registerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (userService.existsByUserName(registerDTO.getUserName()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (userService.existsByEmail(registerDTO.getEmail()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        User user =
                new User(registerDTO.getName(), registerDTO.getUserName(), registerDTO.getEmail(),
                        passwordEncoder.encode(registerDTO.getPassword()));
        Set<Rol> rols = new HashSet<>();
        rols.add(rolService.getByNameRol(NameRol.ROLE_USER).get());
        if (registerDTO.getRoles().contains("admin"))
            rols.add(rolService.getByNameRol(NameRol.ROLE_USER).get());
        user.setRoles(rols);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginDTO loginDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserName(),loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO,HttpStatus.OK);
    }


}

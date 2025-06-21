package com.rods.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.todo.dtos.auth.AuthRequestDto;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager)
    {
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthRequestDto authRequestDto)
    {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authRequestDto.email(), authRequestDto.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }
    
}

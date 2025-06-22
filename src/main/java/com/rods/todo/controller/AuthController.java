package com.rods.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.todo.dtos.auth.AuthRequestDto;
import com.rods.todo.dtos.auth.LoginResponseDto;
import com.rods.todo.dtos.auth.RegisterDto;
import com.rods.todo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody AuthRequestDto authRequestDto)
    {
        authService.login(authRequestDto);
        return ResponseEntity.ok(authService.login(authRequestDto));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarUsuario(@RequestBody RegisterDto registerDto)
    {
        authService.cadastrarUsuario(registerDto);
        return ResponseEntity.ok().build();
    }
    
}

package com.rods.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rods.todo.dtos.auth.AuthRequestDto;
import com.rods.todo.dtos.auth.LoginResponseDto;
import com.rods.todo.dtos.auth.RegisterDto;
import com.rods.todo.entity.Habito;
import com.rods.todo.entity.Usuario;
import com.rods.todo.exception.EntidadeNaoEncontradaException;
import com.rods.todo.exception.UsuarioJaExisteException;
import com.rods.todo.repository.UsuarioRepository;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;
    private JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, JwtService jwtService)
    {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    public LoginResponseDto login(AuthRequestDto authRequestDto)
    {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authRequestDto.email(), authRequestDto.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        UserDetails usuario = usuarioRepository.findByEmail(authRequestDto.email())
            .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario", authRequestDto.email()));

        String token = jwtService.generateToken(usuario);

        return new LoginResponseDto(token, jwtService.getExpirationTime());
    }

    public void cadastrarUsuario(RegisterDto registerDto)
    {

        if(usuarioRepository.findByEmail(registerDto.email()).isPresent())
        {
            throw new UsuarioJaExisteException(registerDto.email());
        }

        List<Habito> habitos = new ArrayList<>();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.senha());

        Usuario usuario = new Usuario(registerDto.username(), registerDto.email(), encryptedPassword,
        LocalDate.now(), habitos);

        usuarioRepository.save(usuario);
    }
    
}

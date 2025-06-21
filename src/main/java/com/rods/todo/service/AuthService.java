package com.rods.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rods.todo.dtos.auth.AuthRequestDto;
import com.rods.todo.dtos.auth.RegisterDto;
import com.rods.todo.entity.Habito;
import com.rods.todo.entity.Usuario;
import com.rods.todo.repository.UsuarioRepository;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;

    public AuthService(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository)
    {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
    }

    public void login(AuthRequestDto authRequestDto)
    {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authRequestDto.email(), authRequestDto.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
    }

    public void cadastrarUsuario(RegisterDto registerDto)
    {
        List<Habito> habitos = new ArrayList<>();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.senha());

        Usuario usuario = new Usuario(registerDto.username(), registerDto.email(), encryptedPassword,
        LocalDate.now(), habitos);

        usuarioRepository.save(usuario);
    }
    
}

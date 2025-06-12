package com.rods.todo.service;

import org.springframework.stereotype.Service;

import com.rods.todo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }
    
}

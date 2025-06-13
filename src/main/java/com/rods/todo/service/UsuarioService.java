package com.rods.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rods.todo.dtos.usuario.UsuarioRequestDto;
import com.rods.todo.dtos.usuario.UsuarioResponseDto;
import com.rods.todo.entity.Habito;
import com.rods.todo.entity.Usuario;
import com.rods.todo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDto cadastrarUsuario(UsuarioRequestDto usuarioRequestDto)
    {
        List<Habito> habitos = new ArrayList<>();
        Usuario usuario = new Usuario(usuarioRequestDto.username(),
        usuarioRequestDto.email(),
        usuarioRequestDto.senha(),
        LocalDate.now(), habitos);

        return new UsuarioResponseDto(usuario);
    }

    
}

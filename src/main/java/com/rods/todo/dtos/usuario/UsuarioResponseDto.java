package com.rods.todo.dtos.usuario;

import com.rods.todo.entity.Usuario;

public record UsuarioResponseDto(String username) {

    public UsuarioResponseDto(Usuario usuario)
    {
        this(usuario.getUsername());
    }
    
}

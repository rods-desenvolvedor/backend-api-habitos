package com.rods.todo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rods.todo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
    
}

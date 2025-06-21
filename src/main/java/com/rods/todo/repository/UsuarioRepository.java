package com.rods.todo.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.rods.todo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

    public UserDetails getByEmail(String email);
    
}

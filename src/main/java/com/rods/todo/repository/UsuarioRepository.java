package com.rods.todo.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.rods.todo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

    public Optional<UserDetails> findByEmail(String email);
    
}

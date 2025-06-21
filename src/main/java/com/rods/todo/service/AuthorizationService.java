package com.rods.todo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rods.todo.repository.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService{

    public UsuarioRepository usuarioRepository;

    public AuthorizationService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username);
    }
    
}

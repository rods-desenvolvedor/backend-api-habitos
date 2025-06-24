package com.rods.todo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rods.todo.entity.Habito;

public interface HabitoRepository extends JpaRepository<Habito, UUID>{

    public List<Habito> findByUsuarioId(UUID idUsuario);
    
}

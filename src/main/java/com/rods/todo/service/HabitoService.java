package com.rods.todo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rods.todo.dtos.habito.HabitoRequestDto;
import com.rods.todo.dtos.habito.HabitoResponseDto;
import com.rods.todo.entity.Habito;
import com.rods.todo.entity.Usuario;
import com.rods.todo.repository.HabitoRepository;
import com.rods.todo.repository.UsuarioRepository;

@Service
public class HabitoService {

    private HabitoRepository habitoRepository;
    private UsuarioRepository usuarioRepository;

    public HabitoService(HabitoRepository habitoRepository, UsuarioRepository usuarioRepository)
    {
        this.habitoRepository = habitoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public HabitoResponseDto cadastrarHabito(HabitoRequestDto habitoRequestDto, UUID idUsuario)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Habito habito = new Habito(habitoRequestDto.titulo(),habitoRequestDto.descricao(),
        LocalDate.of(1, 1, 1), 0, LocalDate.now(), usuario);

        habitoRepository.save(habito);

        return new HabitoResponseDto(habito);
    }

    public List<HabitoResponseDto> listarHabitos(UUID idUsuarioLogado)
    {
        List<Habito> habitos = habitoRepository.findByUsuarioId(idUsuarioLogado);

        return habitos.stream().map(HabitoResponseDto::new).toList();
    }
    
    
}

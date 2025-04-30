package com.example.demo.service;

import com.example.demo.dto.AgendaDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Agenda;
import com.example.demo.model.Usuario;
import com.example.demo.AgendaRepository;
import com.example.demo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private AgendaDTO convertirAAgrendaDTO(Agenda agenda) {
        List<Long> idUsuarios = agenda.getUsuarios().stream()
                .map(Usuario::getIdUsuario)
                .collect(Collectors.toList());

        return new AgendaDTO(agenda.getIdAgenda(), agenda.getNombreAgenda(), idUsuarios);
    }

    private Agenda convertirAAgenda(AgendaDTO agendaDTO) {
        List<Usuario> usuarios = agendaDTO.getIdUsuarios().stream()
                .map(id -> usuarioRepository.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        Agenda agenda = new Agenda();
        agenda.setIdAgenda(agendaDTO.getIdAgenda());
        agenda.setNombreAgenda(agendaDTO.getNombreAgenda());
        agenda.setUsuarios(usuarios);
        return agenda;
    }

    public List<AgendaDTO> obtenerTodas() {
        List<Agenda> agendas = agendaRepository.findAll();
        return agendas.stream().map(this::convertirAAgrendaDTO).collect(Collectors.toList());
    }

    public Optional<AgendaDTO> obtenerPorId(Long idAgenda) {
        return agendaRepository.findById(idAgenda).map(this::convertirAAgrendaDTO);
    }

    public void crearAgenda(AgendaDTO agendaDTO) {
        Agenda agenda = convertirAAgenda(agendaDTO);
        agenda = agendaRepository.save(agenda);
        convertirAAgrendaDTO(agenda);
    }

    public void eliminarAgenda(Long idAgenda) {
        agendaRepository.deleteById(idAgenda);
    }
}

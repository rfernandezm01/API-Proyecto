package com.example.demo.service;

import com.example.demo.dto.AgendaDTO;
import com.example.demo.model.Agenda;
import com.example.demo.model.Mensaje;
import com.example.demo.model.Usuario;
import com.example.demo.AgendaRepository;
import com.example.demo.UsuarioRepository;
import com.example.demo.MensajeRepository;
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

    @Autowired
    private MensajeRepository mensajeRepository;

    private Agenda convertirAEntidad(AgendaDTO dto) {
        List<Usuario> usuarios = usuarioRepository.findAllById(dto.getListaUsuarios());
        List<Mensaje> mensajes = mensajeRepository.findAllById(dto.getListaMensajes());
        return new Agenda(dto.getNomAgenda(), dto.getNotasCalendario(), usuarios, mensajes);
    }

    public List<AgendaDTO> obtenerTodos() {
        return agendaRepository.findAll().stream().map(Agenda::toDTO).collect(Collectors.toList());
    }

    public Optional<AgendaDTO> obtenerPorId(Integer idAgenda) {
        return agendaRepository.findById(idAgenda).map(Agenda::toDTO);
    }

    public AgendaDTO guardar(AgendaDTO agendaDTO) {
        Agenda agenda = convertirAEntidad(agendaDTO);
        agenda = agendaRepository.save(agenda);
        return agenda.toDTO();
    }

    public void eliminar(Integer idAgenda) {
        agendaRepository.deleteById(idAgenda);
    }
}

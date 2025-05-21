package com.example.demo.service;

import com.example.demo.dto.AgendaDTO;
import com.example.demo.model.Agenda;
import com.example.demo.model.Usuario;
import com.example.demo.AgendaRepository;
import com.example.demo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<AgendaDTO> obtenerTodas() {
        return agendaRepository.findAll().stream()
                .map(Agenda::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AgendaDTO> obtenerPorId(Long idAgenda) {
        return agendaRepository.findById(idAgenda)
                .map(Agenda::toDTO);
    }

    @Transactional(readOnly = true)
    public Optional<Agenda> obtenerEntidadPorId(Long idAgenda) {
        return agendaRepository.findById(idAgenda);
    }


    public AgendaDTO crearAgenda(AgendaDTO agendaDTO) {
        List<Usuario> usuariosEntidad = agendaDTO.getIdUsuarios().stream()
                .map(id -> usuarioRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id)))
                .collect(Collectors.toList());

        Agenda agenda = new Agenda(agendaDTO.getNombreAgenda(), usuariosEntidad);
        Agenda guardada = agendaRepository.save(agenda);
        return guardada.toDTO();
    }

    public void eliminarAgenda(Long idAgenda) {
        if (!agendaRepository.existsById(idAgenda)) {
            throw new RuntimeException("Agenda no encontrada con id: " + idAgenda);
        }
        agendaRepository.deleteById(idAgenda);
    }
}
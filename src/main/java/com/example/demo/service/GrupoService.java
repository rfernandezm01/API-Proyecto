package com.example.demo.service;

import com.example.demo.dto.GrupoDTO;
import com.example.demo.model.Agenda;
import com.example.demo.model.Grupo;
import com.example.demo.model.Usuario;
import com.example.demo.GrupoRepository;
import com.example.demo.UsuarioRepository;
import com.example.demo.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    private Grupo convertirAGrupo(GrupoDTO dto) {
        List<Usuario> usuarios = usuarioRepository.findAllById(dto.getListaUsuarios());
        List<Agenda> agendas = agendaRepository.findAllById(dto.getListaAgendas());
        return new Grupo(dto.getNombreGrupo(), dto.getDescripcionGrupo(), usuarios, agendas);
    }

    public List<GrupoDTO> obtenerTodos() {
        return grupoRepository.findAll().stream().map(Grupo::toDTO).collect(Collectors.toList());
    }

    public Optional<GrupoDTO> obtenerPorId(Integer idGrupo) {
        return grupoRepository.findById(idGrupo).map(Grupo::toDTO);
    }

    public GrupoDTO guardar(GrupoDTO grupoDTO) {
        Grupo grupo = convertirAGrupo(grupoDTO);
        grupo = grupoRepository.save(grupo);
        return grupo.toDTO();
    }

    public void eliminar(Integer idGrupo) {
        grupoRepository.deleteById(idGrupo);
    }
}

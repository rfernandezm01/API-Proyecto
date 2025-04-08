package com.example.demo.service;

import com.example.demo.dto.MensajeDTO;
import com.example.demo.model.Mensaje;
import com.example.demo.model.Usuario;
import com.example.demo.MensajeRepository;
import com.example.demo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Mensaje convertirAEntidad(MensajeDTO dto) {
        Usuario emisor = usuarioRepository.findById(dto.getIdUsuarioEmisor())
                .orElseThrow(() -> new RuntimeException("Usuario emisor no encontrado"));
        return new Mensaje(dto.getContenido(), dto.getFechaEnvio(), emisor);
    }

    public List<MensajeDTO> obtenerTodos() {
        return mensajeRepository.findAll().stream()
                .map(Mensaje::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MensajeDTO> obtenerPorId(Integer idMensaje) {
        return mensajeRepository.findById(idMensaje).map(Mensaje::toDTO);
    }

    public MensajeDTO guardar(MensajeDTO mensajeDTO) {
        Mensaje mensaje = convertirAEntidad(mensajeDTO);
        mensaje = mensajeRepository.save(mensaje);
        return mensaje.toDTO();
    }

    public void eliminar(Integer idMensaje) {
        mensajeRepository.deleteById(idMensaje);
    }
}

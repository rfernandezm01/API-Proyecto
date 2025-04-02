package com.example.demo.service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;
import com.example.demo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getContraseña());
    }

    private Usuario convertirAUsuario(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getNombreUsuario(), usuarioDTO.getEmail(), usuarioDTO.getContraseña());
    }

    public List<UsuarioDTO> obtenerTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::convertirAUsuarioDTO).collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> obtenerPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).map(this::convertirAUsuarioDTO);
    }

    public UsuarioDTO guardar(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertirAUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return convertirAUsuarioDTO(usuario);
    }

    public void eliminar(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    public Optional<UsuarioDTO> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email).map(this::convertirAUsuarioDTO);
    }
}

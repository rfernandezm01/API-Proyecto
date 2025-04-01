package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id_usuario}")
    public Optional<UsuarioDTO> obtenerPorId(@PathVariable Long id_usuario) {
        return usuarioService.obtenerPorId(id_usuario);
    }

    @PostMapping
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.guardar(usuarioDTO);
    }

    @DeleteMapping("/{id_usuario}")
    public void eliminarUsuario(@PathVariable Long id_usuario) {
        usuarioService.eliminar(id_usuario);
    }

    @GetMapping("/email/{email}")
    public Optional<UsuarioDTO> obtenerPorEmail(@PathVariable String email) {
        return usuarioService.obtenerPorEmail(email);
    }
}

package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.LoginResponse;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{idUsuario}")
    public Optional<UsuarioDTO> obtenerPorId(@PathVariable Long idUsuario) {
        return usuarioService.obtenerPorId(idUsuario);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<LoginResponse> login(@RequestBody UsuarioDTO request) {
        System.out.println("Email recibido: " + request.getEmail());
        System.out.println("Contraseña recibida: " + request.getPassword());
        Optional<UsuarioDTO> usuario = usuarioService.obtenerPorEmail(request.getEmail());

        if (usuario.isPresent() && usuario.get().getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse(true, "El nombre de usuario ya está en uso."));
        } else {
            return ResponseEntity.ok(new LoginResponse(false, "El nombre de usuario ya está en uso."));
        }
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable Long idUsuario) {
        usuarioService.eliminar(idUsuario);
    }

    @GetMapping("/email/{email}")
    public Optional<UsuarioDTO> obtenerPorEmail(@PathVariable String email) {
        return usuarioService.obtenerPorEmail(email);
    }
}
package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;
import com.example.demo.UsuarioRepository;
import com.example.demo.service.LoginResponse;
import com.example.demo.service.RegisterResponse;
import com.example.demo.service.UserSearchResponse;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDTO> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{idUsuario}")
    public Optional<UsuarioDTO> obtenerPorId(@PathVariable Long idUsuario) {
        return usuarioService.obtenerPorId(idUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UsuarioDTO request) {
        Optional<UsuarioDTO> usuario = usuarioService.obtenerPorEmail(request.getEmail());

        if (usuario.isPresent() && usuario.get().getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(
                    new LoginResponse(true, "Inicio de sesión exitoso.", usuario.get().getNombreUsuario())
            );
        } else {
            return ResponseEntity.ok(
                    new LoginResponse(false, "Correo o contraseña incorrectos.", null)
            );
        }
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody UsuarioDTO request) {
        Optional<UsuarioDTO> usuarioExistente = usuarioService.obtenerPorEmail(request.getEmail());

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.ok(new RegisterResponse(false, "El correo electrónico ya está registrado."));
        } else {
            usuarioService.registrarUsuario(request);
            return ResponseEntity.ok(new RegisterResponse(true, "Usuario registrado correctamente."));
        }
    }

    @PostMapping("/searchUser")
    public ResponseEntity<UserSearchResponse> searchUser(@RequestBody UsuarioDTO request) {
        String query = request.getQuery();
        List<Usuario> coincidencias = usuarioRepository.findByNombreUsuarioContainingIgnoreCase(query);

        List<UserSearchResponse.Usuario> usuarios = coincidencias.stream().map(usuario ->
                new UserSearchResponse.Usuario(usuario.getIdUsuario(), usuario.getNombreUsuario())
        ).collect(Collectors.toList());

        return ResponseEntity.ok(new UserSearchResponse(true, usuarios));
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
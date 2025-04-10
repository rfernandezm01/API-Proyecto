package com.example.demo;

import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByEmailOrNombreUsuario(String email, String nombreUsuario);
}
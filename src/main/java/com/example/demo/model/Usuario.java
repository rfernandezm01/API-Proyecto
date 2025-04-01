package com.example.demo.model;

import com.example.demo.dto.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    private String nombre_usuario;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String contraseña;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre_usuario, String email, String contraseña) {
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.contraseña = contraseña;
    }

    // Constructor que recibe un DTO
    public Usuario(UsuarioDTO usuarioDTO) {
        this.id_usuario = usuarioDTO.getId_usuario();
        this.nombre_usuario = usuarioDTO.getNombre_usuario();
        this.email = usuarioDTO.getEmail();
        this.contraseña = usuarioDTO.getContraseña();
    }

    // Convertir a DTO
    public UsuarioDTO toDTO() {
        return new UsuarioDTO(id_usuario, nombre_usuario, email, contraseña);
    }

    // Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

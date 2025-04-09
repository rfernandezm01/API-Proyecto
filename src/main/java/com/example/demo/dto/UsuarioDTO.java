package com.example.demo.dto;

import com.example.demo.model.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;

public class UsuarioDTO {
    private Long idUsuario;
    private String nombreUsuario;
    private String email;
    private String password;

    public UsuarioDTO() {}

    public UsuarioDTO(Long idUsuario, String nombreUsuario, String email, String password) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }
}

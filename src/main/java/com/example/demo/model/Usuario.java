package com.example.demo.model;

import com.example.demo.dto.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombreUsuario, String email, String password) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    // Constructor que recibe un DTO
    public Usuario(UsuarioDTO usuarioDTO) {
        this.idUsuario = usuarioDTO.getIdUsuario();
        this.nombreUsuario = usuarioDTO.getNombreUsuario();
        this.email = usuarioDTO.getEmail();
        this.password = usuarioDTO.getContraseña();
    }

    // Convertir a DTO
    public UsuarioDTO toDTO() {
        return new UsuarioDTO(idUsuario, nombreUsuario, email, password);
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

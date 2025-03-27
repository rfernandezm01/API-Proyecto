package com.example.demo.model;

import com.example.demo.dto.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;

    @Column(unique = true)
    private String email;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Constructor que recibe un DTO
    public Usuario(UsuarioDTO usuarioDTO) {
        this.nombre = usuarioDTO.getNombre();
        this.email = usuarioDTO.getEmail();
    }

    // Convertir a DTO
    public UsuarioDTO toDTO() {
        return new UsuarioDTO(id, nombre, email);
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

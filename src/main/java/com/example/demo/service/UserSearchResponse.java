package com.example.demo.service;

import java.util.List;

public class UserSearchResponse {
    private boolean success;
    private List<Usuario> usuarios;

    public UserSearchResponse() {}

    public UserSearchResponse(boolean success, List<Usuario> usuarios) {
        this.success = success;
        this.usuarios = usuarios;
    }

    // Getters y setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public static class Usuario {
        private Long id;
        private String nombreUsuario;

        public Usuario() {}

        public Usuario(Long id, String nombreUsuario) {
            this.id = id;
            this.nombreUsuario = nombreUsuario;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }
    }
}
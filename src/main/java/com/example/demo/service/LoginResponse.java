package com.example.demo.service;

public class LoginResponse {
    private boolean success;
    private String message;
    private String nombreUsuario;

    public LoginResponse(boolean success, String message, String nombreUsuario) {
        this.success = success;
        this.message = message;
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
package com.example.demo.dto;

import java.util.Date;

public class MensajeDTO {
    private Integer idMensaje;
    private String contenido;
    private Date fechaEnvio;
    private Long idUsuarioEmisor;

    public MensajeDTO() {}

    public MensajeDTO(Integer idMensaje, String contenido, Date fechaEnvio, Long idUsuarioEmisor) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.idUsuarioEmisor = idUsuarioEmisor;
    }

    // Getters y setters
    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Long getIdUsuarioEmisor() {
        return idUsuarioEmisor;
    }

    public void setIdUsuarioEmisor(Long idUsuarioEmisor) {
        this.idUsuarioEmisor = idUsuarioEmisor;
    }
}

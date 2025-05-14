package com.example.demo.service;

import java.time.LocalDateTime;

public class MensajeResponse {

    private Long id;
    private String texto;
    private String autor;
    private Long agendaId;
    private LocalDateTime timestamp;

    public MensajeResponse(Long id, String texto, String autor, Long agendaId, LocalDateTime timestamp) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.agendaId = agendaId;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public String getAutor() {
        return autor;
    }

    public Long getAgendaId() {
        return agendaId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
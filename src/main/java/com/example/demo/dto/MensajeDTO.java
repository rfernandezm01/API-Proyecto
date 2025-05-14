package com.example.demo.dto;

public class MensajeDTO {

    private String texto;
    private String autor;
    private Long agendaId;

    public MensajeDTO(String texto, String autor, Long agendaId) {
        this.texto = texto;
        this.autor = autor;
        this.agendaId = agendaId;
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

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }
}

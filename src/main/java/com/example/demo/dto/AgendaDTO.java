package com.example.demo.dto;

import java.util.List;

public class AgendaDTO {
    private Integer idAgenda;
    private String nomAgenda;
    private String notasCalendario;
    private List<Long> listaUsuarios;
    private List<Long> listaMensajes;

    public AgendaDTO() {}

    public AgendaDTO(Integer idAgenda, String nomAgenda, String notasCalendario,
                     List<Long> listaUsuarios, List<Long> listaMensajes) {
        this.idAgenda = idAgenda;
        this.nomAgenda = nomAgenda;
        this.notasCalendario = notasCalendario;
        this.listaUsuarios = listaUsuarios;
        this.listaMensajes = listaMensajes;
    }

    // Getters y Setters
    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getNomAgenda() {
        return nomAgenda;
    }

    public void setNomAgenda(String nomAgenda) {
        this.nomAgenda = nomAgenda;
    }

    public String getNotasCalendario() {
        return notasCalendario;
    }

    public void setNotasCalendario(String notasCalendario) {
        this.notasCalendario = notasCalendario;
    }

    public List<Long> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Long> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Long> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Long> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
}

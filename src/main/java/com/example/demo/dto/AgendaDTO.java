package com.example.demo.dto;

import java.util.List;

public class AgendaDTO {
    private Long idAgenda;
    private String nombreAgenda;
    private List<Long> idUsuarios;

    public AgendaDTO(Long idAgenda, String nombreAgenda, List<Long> idUsuarios) {
        this.idAgenda = idAgenda;
        this.nombreAgenda = nombreAgenda;
        this.idUsuarios = idUsuarios;
    }
    
    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getNombreAgenda() {
        return nombreAgenda;
    }

    public void setNombreAgenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
    }

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(List<Long> idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}
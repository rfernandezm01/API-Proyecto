package com.example.demo.dto;

import java.util.List;

public class GrupoDTO {
    private Integer idGrupo;
    private String nombreGrupo;
    private String descripcionGrupo;
    private List<Long> listaUsuarios;  // Solo IDs de usuario
    private List<Long> listaAgendas;   // Solo IDs de agenda

    public GrupoDTO() {}

    public GrupoDTO(Integer idGrupo, String nombreGrupo, String descripcionGrupo,
                    List<Long> listaUsuarios, List<Long> listaAgendas) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.descripcionGrupo = descripcionGrupo;
        this.listaUsuarios = listaUsuarios;
        this.listaAgendas = listaAgendas;
    }

    // Getters y setters
    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }

    public List<Long> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Long> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Long> getListaAgendas() {
        return listaAgendas;
    }

    public void setListaAgendas(List<Long> listaAgendas) {
        this.listaAgendas = listaAgendas;
    }
}

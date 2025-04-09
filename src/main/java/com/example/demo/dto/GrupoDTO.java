package com.example.demo.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class GrupoDTO {
    private Integer idGrupo;
    private String nombreGrupo;
    private String descripcionGrupo;
    private List<Integer> listaUsuarios;  // Solo IDs de usuario
    private List<Integer> listaAgendas;   // Solo IDs de agenda

    public GrupoDTO() {}

    public GrupoDTO(Integer idGrupo, String nombreGrupo, String descripcionGrupo,
                    List<Integer> listaUsuarios, List<Integer> listaAgendas) {
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

    public List<Integer> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Integer> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Integer> getListaAgendas() {
        return listaAgendas;
    }

    public void setListaAgendas(List<Integer> listaAgendas) {
        this.listaAgendas = listaAgendas;
    }
}

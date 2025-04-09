package com.example.demo.model;

import com.example.demo.dto.GrupoDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "nombre_grupo", nullable = false)
    private String nombreGrupo;

    @Column(name = "descripcion_grupo")
    private String descripcionGrupo;

    @ManyToMany
    @JoinTable(
            name = "grupo_usuario",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> listaUsuarios;

    @OneToMany(mappedBy = "grupo")
    private List<Agenda> listaAgendas;

    public Grupo() {}

    public Grupo(String nombreGrupo, String descripcionGrupo, List<Usuario> listaUsuarios, List<Agenda> listaAgendas) {
        this.nombreGrupo = nombreGrupo;
        this.descripcionGrupo = descripcionGrupo;
        this.listaUsuarios = listaUsuarios;
        this.listaAgendas = listaAgendas;
    }

    public GrupoDTO toDTO() {
        return new GrupoDTO(
                idGrupo,
                nombreGrupo,
                descripcionGrupo,
                listaUsuarios.stream()
                        .map(usuario -> usuario.getIdUsuario().intValue())
                        .collect(Collectors.toList()),
                listaAgendas.stream().map(Agenda::getIdAgenda).collect(Collectors.toList())
        );
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    // Getters y Setters
    // ...
}

package com.example.demo.model;

import com.example.demo.dto.AgendaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "agendas")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda", nullable = false)
    private Long idAgenda;

    @Column(name = "nombre_agenda", nullable = false)
    private String nombreAgenda;

    @ManyToMany
    @JoinTable(
            name = "agenda_usuarios",
            joinColumns = @JoinColumn(name = "id_agenda"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios = new ArrayList<>();

    public Agenda() {}

    public Agenda(String nombreAgenda, List<Usuario> usuarios) {
        this.nombreAgenda = nombreAgenda;
        this.usuarios = usuarios;
    }

    public Agenda(AgendaDTO dto, List<Usuario> usuarios) {
        this.idAgenda = dto.getIdAgenda();
        this.nombreAgenda = dto.getNombreAgenda();
        this.usuarios = usuarios;
    }

    public AgendaDTO toDTO() {
        List<Long> idUsuarios = usuarios.stream()
                .map(Usuario::getIdUsuario)
                .collect(Collectors.toList());

        return new AgendaDTO(idAgenda, nombreAgenda, idUsuarios);
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
package com.example.demo.model;

import com.example.demo.dto.AgendaDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "agendas")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda")
    private Integer idAgenda;

    @Column(name = "nom_agenda", nullable = false)
    private String nomAgenda;

    @Column(name = "notas_calendario")
    private String notasCalendario;

    @ManyToMany
    @JoinTable(
            name = "agenda_usuario",
            joinColumns = @JoinColumn(name = "id_agenda"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> listaUsuarios;

    @OneToMany(mappedBy = "agenda")
    private List<Mensaje> listaMensajes;

    public Agenda() {}

    public Agenda(String nomAgenda, String notasCalendario, List<Usuario> listaUsuarios, List<Mensaje> listaMensajes) {
        this.nomAgenda = nomAgenda;
        this.notasCalendario = notasCalendario;
        this.listaUsuarios = listaUsuarios;
        this.listaMensajes = listaMensajes;
    }

    public AgendaDTO toDTO() {
        return new AgendaDTO(
                idAgenda,
                nomAgenda,
                notasCalendario,
                listaUsuarios.stream().map(Usuario::getIdUsuario).collect(Collectors.toList()),
                listaMensajes.stream().map(Mensaje::getIdMensaje).collect(Collectors.toList())
        );
    }

    // Getters y Setters
    // ...
}

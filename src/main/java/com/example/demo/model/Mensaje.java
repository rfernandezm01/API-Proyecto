package com.example.demo.model;

import com.example.demo.dto.MensajeDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Integer idMensaje;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fecha_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    @ManyToOne
    @JoinColumn(name = "usuario_emisor", nullable = false)
    private Usuario usuarioEmisor;

    @ManyToOne
    @JoinColumn(name = "id_agenda") // si quieres asociar mensaje a agenda
    private Agenda agenda;

    public Mensaje() {}

    public Mensaje(String contenido, Date fechaEnvio, Usuario usuarioEmisor) {
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.usuarioEmisor = usuarioEmisor;
    }

    public MensajeDTO toDTO() {
        return new MensajeDTO(idMensaje, contenido, fechaEnvio, usuarioEmisor.getIdUsuario());
    }

    // Getters y Setters
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

    public Usuario getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Usuario usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}

package com.example.demo.model;

import com.example.demo.dto.ChatDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chat")
    private Integer idChat;

    @OneToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupo grupo;

    @OneToMany
    @JoinColumn(name = "chat_id") // Campo en tabla de mensajes que apunta al chat
    private List<Mensaje> listaMensajes;

    public Chat() {}

    public Chat(Grupo grupo, List<Mensaje> listaMensajes) {
        this.grupo = grupo;
        this.listaMensajes = listaMensajes;
    }

    public ChatDTO toDTO() {
        return new ChatDTO(
                idChat,
                grupo.getIdGrupo(),
                listaMensajes.stream().map(Mensaje::getIdMensaje).collect(Collectors.toList())
        );
    }

    // Getters y Setters
    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


    public List<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
}

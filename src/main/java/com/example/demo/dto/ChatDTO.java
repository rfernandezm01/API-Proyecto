package com.example.demo.dto;

import java.util.List;

public class ChatDTO {
    private Integer idChat;
    private Integer idGrupo;
    private List<Integer> listaMensajes;

    public ChatDTO() {}

    public ChatDTO(Integer idChat, Integer idGrupo, List<Integer> listaMensajes) {
        this.idChat = idChat;
        this.idGrupo = idGrupo;
        this.listaMensajes = listaMensajes;
    }

    // Getters y Setters
    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public List<Integer> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Integer> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
}

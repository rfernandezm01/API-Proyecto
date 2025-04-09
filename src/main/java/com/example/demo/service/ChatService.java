package com.example.demo.service;

import com.example.demo.dto.ChatDTO;
import com.example.demo.model.Chat;
import com.example.demo.model.Grupo;
import com.example.demo.model.Mensaje;
import com.example.demo.ChatRepository;
import com.example.demo.GrupoRepository;
import com.example.demo.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private MensajeRepository mensajeRepository;

    private Chat convertirAEntidad(ChatDTO dto) {
        Grupo grupo = grupoRepository.findById(dto.getIdGrupo()).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        List<Mensaje> mensajes = mensajeRepository.findAllById(dto.getListaMensajes());

        return new Chat(grupo, mensajes);
    }

    public List<ChatDTO> obtenerTodos() {
        return chatRepository.findAll().stream().map(Chat::toDTO).collect(Collectors.toList());
    }

    public Optional<ChatDTO> obtenerPorId(Integer idChat) {
        return chatRepository.findById(idChat).map(Chat::toDTO);
    }

    public ChatDTO guardar(ChatDTO chatDTO) {
        Chat chat = convertirAEntidad(chatDTO);
        chat = chatRepository.save(chat);
        return chat.toDTO();
    }

    public void eliminar(Integer idChat) {
        chatRepository.deleteById(idChat);
    }

    public Optional<ChatDTO> obtenerPorGrupo(Long idGrupo) {
        Chat chat = chatRepository.findByGrupoIdGrupo(idGrupo);
        return Optional.ofNullable(chat != null ? chat.toDTO() : null);
    }
}

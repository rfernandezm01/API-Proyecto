package com.example.demo.controller;

import com.example.demo.dto.ChatDTO;
import com.example.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chats")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public List<ChatDTO> obtenerTodos() {
        return chatService.obtenerTodos();
    }

    @GetMapping("/{idChat}")
    public Optional<ChatDTO> obtenerPorId(@PathVariable Integer idChat) {
        return chatService.obtenerPorId(idChat);
    }

    @PostMapping
    public ChatDTO crearChat(@RequestBody ChatDTO chatDTO) {
        return chatService.guardar(chatDTO);
    }

    @DeleteMapping("/{idChat}")
    public void eliminarChat(@PathVariable Integer idChat) {
        chatService.eliminar(idChat);
    }

    @GetMapping("/grupo/{idGrupo}")
    public Optional<ChatDTO> obtenerPorGrupo(@PathVariable Long idGrupo) {
        return chatService.obtenerPorGrupo(idGrupo);
    }
}

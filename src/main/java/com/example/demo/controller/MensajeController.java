package com.example.demo.controller;

import com.example.demo.dto.MensajeDTO;
import com.example.demo.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mensajes")
@CrossOrigin(origins = "*")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping
    public List<MensajeDTO> obtenerTodos() {
        return mensajeService.obtenerTodos();
    }

    @GetMapping("/{idMensaje}")
    public Optional<MensajeDTO> obtenerPorId(@PathVariable Integer idMensaje) {
        return mensajeService.obtenerPorId(idMensaje);
    }

    @PostMapping
    public MensajeDTO crearMensaje(@RequestBody MensajeDTO mensajeDTO) {
        return mensajeService.guardar(mensajeDTO);
    }

    @DeleteMapping("/{idMensaje}")
    public void eliminarMensaje(@PathVariable Integer idMensaje) {
        mensajeService.eliminar(idMensaje);
    }
}

package com.example.demo.controller;

import com.example.demo.dto.MensajeDTO;
import com.example.demo.service.MensajeService;
import com.example.demo.service.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajes")
@CrossOrigin(origins = "*")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/agenda/{idAgenda}")
    public ResponseEntity<List<MensajeResponse>> obtenerMensajesPorAgenda(@PathVariable Long idAgenda) {
        List<MensajeResponse> mensajes = mensajeService.obtenerMensajesPorAgenda(idAgenda);
        return ResponseEntity.ok(mensajes);
    }

    @PostMapping("/enviar")
    public ResponseEntity<MensajeResponse> enviarMensaje(@RequestBody MensajeDTO request) {
        MensajeResponse mensajeResponse = mensajeService.enviarMensaje(request);
        return ResponseEntity.ok(mensajeResponse);
    }

    @DeleteMapping("/{idMensaje}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable Long idMensaje) {
        mensajeService.eliminarMensaje(idMensaje);
        return ResponseEntity.ok().build();
    }
}
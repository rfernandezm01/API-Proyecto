package com.example.demo.controller;

import com.example.demo.dto.AgendaDTO;
import com.example.demo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
@CrossOrigin(origins = "*")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<AgendaDTO> obtenerTodas() {
        return agendaService.obtenerTodas();
    }

    @GetMapping("/{idAgenda}")
    public Optional<AgendaDTO> obtenerPorId(@PathVariable Long idAgenda) {
        return agendaService.obtenerPorId(idAgenda);
    }

    @PostMapping
    public ResponseEntity<AgendaDTO> crearAgenda(@RequestBody AgendaDTO agendaDTO) {
        try {
            AgendaDTO creada = agendaService.crearAgenda(agendaDTO);
            return ResponseEntity.ok(creada);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{idAgenda}")
    public ResponseEntity<String> eliminarAgenda(@PathVariable Long idAgenda) {
        agendaService.eliminarAgenda(idAgenda);
        return ResponseEntity.ok("Agenda eliminada correctamente.");
    }
}
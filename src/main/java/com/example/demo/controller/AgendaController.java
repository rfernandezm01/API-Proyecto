package com.example.demo.controller;

import com.example.demo.dto.AgendaDTO;
import com.example.demo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<AgendaDTO> obtenerTodos() {
        return agendaService.obtenerTodos();
    }

    @GetMapping("/{idAgenda}")
    public Optional<AgendaDTO> obtenerPorId(@PathVariable Integer idAgenda) {
        return agendaService.obtenerPorId(idAgenda);
    }

    @PostMapping
    public AgendaDTO crearAgenda(@RequestBody AgendaDTO agendaDTO) {
        return agendaService.guardar(agendaDTO);
    }

    @DeleteMapping("/{idAgenda}")
    public void eliminarAgenda(@PathVariable Integer idAgenda) {
        agendaService.eliminar(idAgenda);
    }
}

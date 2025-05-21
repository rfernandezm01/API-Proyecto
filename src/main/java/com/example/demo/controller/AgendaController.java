package com.example.demo.controller;

import com.example.demo.dto.AgendaDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Agenda;
import com.example.demo.model.Usuario;
import com.example.demo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{idAgenda}")
    public ResponseEntity<String> eliminarAgenda(@PathVariable Long idAgenda) {
        agendaService.eliminarAgenda(idAgenda);
        return ResponseEntity.ok("Agenda eliminada correctamente.");
    }

    @GetMapping("/{agendaId}/miembros")
    public ResponseEntity<List<UsuarioDTO>> obtenerMiembrosDeAgenda(@PathVariable Long agendaId) {
        Optional<AgendaDTO> agendaDTOOptional = agendaService.obtenerPorId(agendaId);

        if (agendaDTOOptional.isPresent()) {
            Optional<Agenda> agendaEntidadOptional = agendaService.obtenerEntidadPorId(agendaId);

            if (agendaEntidadOptional.isPresent()) {
                List<Usuario> miembrosEntidad = agendaEntidadOptional.get().getUsuarios();
                if (miembrosEntidad == null || miembrosEntidad.isEmpty()) {
                    return ResponseEntity.ok(new ArrayList<>());
                }

                List<UsuarioDTO> miembrosRespuesta = miembrosEntidad.stream()
                        .map(usuario -> new UsuarioDTO(
                                usuario.getIdUsuario(),
                                usuario.getNombreUsuario(),
                                usuario.getEmail(),
                                null))
                        .collect(Collectors.toList());
                return ResponseEntity.ok(miembrosRespuesta);

            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
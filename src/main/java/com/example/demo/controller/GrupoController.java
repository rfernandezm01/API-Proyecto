package com.example.demo.controller;

import com.example.demo.dto.GrupoDTO;
import com.example.demo.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
@CrossOrigin(origins = "*")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<GrupoDTO> obtenerTodos() {
        return grupoService.obtenerTodos();
    }

    @GetMapping("/{idGrupo}")
    public Optional<GrupoDTO> obtenerPorId(@PathVariable Integer idGrupo) {
        return grupoService.obtenerPorId(idGrupo);
    }

    @PostMapping
    public GrupoDTO crearGrupo(@RequestBody GrupoDTO grupoDTO) {
        return grupoService.guardar(grupoDTO);
    }

    @DeleteMapping("/{idGrupo}")
    public void eliminarGrupo(@PathVariable Integer idGrupo) {
        grupoService.eliminar(idGrupo);
    }
}

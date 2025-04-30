package com.example.demo;

import com.example.demo.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    Optional<Agenda> findByNombreAgenda(String nombreAgenda);
    boolean existsByNombreAgenda(String nombreAgenda);
}
package com.example.demo;

import com.example.demo.model.AgendaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaUsuarioRepository extends JpaRepository<AgendaUsuario, Long> {

}
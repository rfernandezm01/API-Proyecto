package com.example.demo.service;

import com.example.demo.dto.MensajeDTO;
import com.example.demo.model.Mensaje;
import com.example.demo.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<MensajeResponse> obtenerMensajesPorAgenda(Long agendaId) {
        List<Mensaje> mensajes = mensajeRepository.findByAgendaId(agendaId);
        return mensajes.stream().map(mensaje ->
                new MensajeResponse(mensaje.getId(), mensaje.getTexto(), mensaje.getAutor(), mensaje.getAgendaId(), mensaje.getTimestamp())
        ).collect(Collectors.toList());
    }

    public MensajeResponse enviarMensaje(MensajeDTO request) {
        Mensaje mensaje = new Mensaje(request.getTexto(), request.getAutor(), request.getAgendaId());
        mensajeRepository.save(mensaje);
        return new MensajeResponse(mensaje.getId(), mensaje.getTexto(), mensaje.getAutor(), mensaje.getAgendaId(), mensaje.getTimestamp());
    }

    public void eliminarMensaje(Long idMensaje) {
        mensajeRepository.deleteById(idMensaje);
    }
}

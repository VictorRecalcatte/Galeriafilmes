package com.projeto.service;

import com.projeto.model.Evento;
import com.projeto.model.Reserva;
import com.projeto.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> buscarReservasPorUsuario(Long id_usuario) {
        return reservaRepository.findByIdUsuario(id_usuario);
    }

    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deletar(Long id){
        reservaRepository.deleteById(id);
    }

}

package com.projeto.controller;


import com.projeto.model.Evento;
import com.projeto.model.Reserva;
import com.projeto.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    //

    @GetMapping("/usuario/{id_usuario}")
    public ResponseEntity<List<Reserva>> obterReservasPorUsuario(@PathVariable("id_usuario") Long idUsuario) {
        List<Reserva> reservas = reservaService.buscarReservasPorUsuario(idUsuario);
        if (reservas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reservas);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Reserva> cadastrarReserva(@RequestBody Reserva novaReserva) {
        Reserva reservaSalva = reservaService.salvarReserva(novaReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaSalva);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reservaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

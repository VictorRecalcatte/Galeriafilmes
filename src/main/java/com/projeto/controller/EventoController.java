package com.projeto.controller;

import com.projeto.model.Evento;
import com.projeto.model.Usuario;
import com.projeto.service.EventoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired

    private EventoService eventoService;

    @GetMapping("/listar")
    public List<Evento> listar(){
        return eventoService.listartodos();
    }

    @PostMapping("/add")
    public Evento adicionar(@RequestBody Evento evento){
        return eventoService.salvar(evento);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento eventoAtualizado) {
        try {
            // Chama o método atualizar no serviço, que retorna o evento atualizado
            Evento evento = eventoService.atualizar(id, eventoAtualizado);

            // Retorna a resposta com o evento atualizado
            return ResponseEntity.ok(evento);
        } catch (EntityNotFoundException e) {
            // Caso o evento não seja encontrado, retorna 404
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        eventoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

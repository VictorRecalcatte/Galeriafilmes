package com.projeto.service;

import com.projeto.model.Evento;
import com.projeto.model.Usuario;
import com.projeto.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired

    private EventoRepository eventoRepository;

    public List<Evento> listartodos() {
        return eventoRepository.findAll();
    }

    public Evento salvar(Evento evento){
        return eventoRepository.save(evento);
    }
    public Evento atualizar(Long id, Evento eventoAtualizado) {
        return eventoRepository.findById(id)
                .map(evento -> {
                    evento.setNome(eventoAtualizado.getNome());
                    evento.setDescricao(eventoAtualizado.getDescricao());
                    // Atualize outros campos conforme necessário
                    return eventoRepository.save(evento);
                })
                .orElseThrow(() -> new EntityNotFoundException("Evento com ID " + id + " não encontrado."));
    }


    public void deletar(Long id){
        eventoRepository.deleteById(id);
    }

}

package com.projeto.service;

import com.projeto.model.Filme;
import com.projeto.repository.FilmeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> listartodos() {
        return filmeRepository.findAll();
    }

    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }

    public Filme atualizar(Long id, Filme filmeAtualizado) {
        return filmeRepository.findById(id)
                .map(filme -> {
                    filme.setTitulo(filmeAtualizado.getTitulo());
                    filme.setDescricao(filmeAtualizado.getDescricao());
                    return filmeRepository.save(filme);
                })
                .orElseThrow(() -> new EntityNotFoundException("Filme com ID " + id + " não encontrado."));
    }
}

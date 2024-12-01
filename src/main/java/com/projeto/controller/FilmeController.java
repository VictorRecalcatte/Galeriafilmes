package com.projeto.controller;

import com.projeto.model.Filme;
import com.projeto.service.FilmeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    @Autowired

    private FilmeService filmeService;

    @GetMapping("/listar")
    public List<Filme> listar(){
        return filmeService.listartodos();
    }

    @PostMapping("/add")
    public Filme adicionar(@RequestBody Filme filme){
        return filmeService.salvar(filme);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable Long id, @RequestBody Filme filmeatualizado) {
        try {
            // Chama o método atualizar no serviço, que retorna o evento atualizado
            Filme filme = filmeService.atualizar(id, filmeatualizado);

            // Retorna a resposta com o evento atualizado
            return ResponseEntity.ok(filme);
        } catch (EntityNotFoundException e) {
            // Caso o evento não seja encontrado, retorna 404
            return ResponseEntity.notFound().build();
        }
    }

}

package com.projeto.controller;

import com.projeto.DTO.LoginDTO;
import com.projeto.model.Usuario;
import com.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/listar")
    public List<Usuario> listar(){
        return usuarioService.listartodos();
    }

    @PostMapping("/add")
    public Usuario adicionar (@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO loginDTO) {
        Usuario usuario = usuarioService.login(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok(usuario);
    }
}

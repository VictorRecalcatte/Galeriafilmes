package com.projeto.service;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired

    private UsuarioRepository usuarioRepository;

    public List<Usuario> listartodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario login(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha)
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));
    }
}

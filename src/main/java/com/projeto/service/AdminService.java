package com.projeto.service;

import com.projeto.model.Admin;
import com.projeto.model.Usuario;
import com.projeto.repository.AdminRepository;
import com.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired

    private AdminRepository adminRepository;

    public List<Admin> listartodos(){
        return adminRepository.findAll();
    }

    public Admin salvar(Admin admin){
        return adminRepository.save(admin);
    }

    public void deletar(Long id){
        adminRepository.deleteById(id);
    }

    public Admin login(String email, String senha) {
        return adminRepository.findByEmailAndSenha(email, senha)
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));
    }




}

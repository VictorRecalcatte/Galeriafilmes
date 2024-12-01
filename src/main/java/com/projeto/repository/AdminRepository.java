package com.projeto.repository;

import com.projeto.model.Admin;
import com.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmailAndSenha(String email, String senha);
}

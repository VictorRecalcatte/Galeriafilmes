package com.projeto.controller;

import com.projeto.DTO.LoginDTO;
import com.projeto.model.Admin;
import com.projeto.model.Usuario;
import com.projeto.service.AdminService;
import com.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/listar")
    public  List<Admin> listar(){
        return adminService.listartodos();
    }

    @PostMapping("/add")
    public Admin adicionar (@RequestBody Admin admin){
        return adminService.salvar(admin);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        adminService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody LoginDTO loginDTO) {
        Admin admin = adminService.login(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok(admin);
    }

}

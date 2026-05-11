/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.controller;

import com.gerenciadordecolecoes.gerenciador.model.UsuarioDTO;
import com.gerenciadordecolecoes.gerenciador.service.TokenService;
import com.gerenciadordecolecoes.gerenciador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author farma
 */
@RestController
@RequestMapping("/api")
public class UsuarioAPIController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired TokenService tokenService;
    
    @PostMapping("/cadastro")
    public String cadastrar(@RequestBody UsuarioDTO usuario) {
        usuarioService.cadastrar(usuario);
        return "Usuário cadastrado com sucesso!";
    }
    
    @PostMapping("/login")
    public String logar(@RequestBody UsuarioDTO user) {
        UsuarioDTO usuario = usuarioService.logar(user.getEmail(), user.getSenha());
        if(usuario.getEmail() != null) {
            return tokenService.gerarToken(usuario.getEmail());
        } else{
            return "inválido";
        }
    } 
}

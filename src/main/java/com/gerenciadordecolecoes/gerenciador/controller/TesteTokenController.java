/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.controller;

import com.gerenciadordecolecoes.gerenciador.service.TokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author farma
 */
@RestController
public class TesteTokenController {
    
    @Autowired
    private TokenService service;
    
    @PostMapping("/validar-token")
    public String validarToken(@RequestParam String token) {
        if(service.validarToken(token)) {
            Claims claims = service.extrairClaims(token);
            return "Token válido! Subject: " + claims.getSubject() + ", Emitido em: " + claims.getIssuedAt() + ", Expira em: " + claims.getExpiration();
        } else{
            return "Token inválido ou expirado!";
        }
    }
}

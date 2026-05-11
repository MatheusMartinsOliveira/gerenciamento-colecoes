/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.controller;

import com.gerenciadordecolecoes.gerenciador.model.LocalDTO;
import com.gerenciadordecolecoes.gerenciador.service.LocaisService;
import com.gerenciadordecolecoes.gerenciador.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author farma
 */
@RestController
@RequestMapping("/api/locais")
public class LocaisAPIController {
    
    @Autowired
    private LocaisService locaisService;
    
    @Autowired
    private TokenService tokenService;
    
    @GetMapping("/listar")
    public List<LocalDTO> listarLocais(@RequestHeader("Authorization") String auth){
        String token = auth.replace("Bearer ", "");
        if(tokenService.validarToken(token)) {
            return locaisService.listarLocais();
        }
        else{
            return null;
        }
    }
}

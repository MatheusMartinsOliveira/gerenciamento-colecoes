/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.controller;

import com.gerenciadordecolecoes.gerenciador.model.LocalDTO;
import com.gerenciadordecolecoes.gerenciador.service.LocaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/listar")
    public List<LocalDTO> listarLocais(){
        return locaisService.listarLocais();
    }
}

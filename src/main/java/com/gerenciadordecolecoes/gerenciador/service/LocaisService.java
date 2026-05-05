/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.service;

import com.gerenciadordecolecoes.gerenciador.model.LocalDTO;
import com.gerenciadordecolecoes.gerenciador.repository.LocaisDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author farma
 */
@Service
public class LocaisService {
    @Autowired
    private LocaisDAO repository;
    
    public List<LocalDTO> listarLocais() {
        return repository.listarLocal();
    }
}

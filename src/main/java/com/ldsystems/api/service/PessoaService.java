/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldsystems.api.service;

import com.ldsystems.api.model.Pessoa;
import com.ldsystems.api.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
//Nesse caso vamos usar a anotação service, funciona tal qual a @Component... no caso como essa classe é um service vamos usa-la
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(com.ldsystems.api.repository.PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getListPessoas() {
        return pessoaRepository.findAll();
    }
}

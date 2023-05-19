/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldsystems.api.controller;

import com.ldsystems.api.model.Pessoa;
import com.ldsystems.api.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(path = "api/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    //Injeção dependência para o construtor.. sempre essa instancia será feita automaticamente pra nós
    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    //É respeitada a hierarquia dos pacotes, colocar os controller como pacotes filhos da API!
    //Retorna lista de Pessoa(HTTP GET)
    @GetMapping
    public List<Pessoa> getListPessoas() {
        return pessoaService.getListPessoas();
    }
    
    //Salva um novo registro de Pessoa (HTTP POST)
    @PostMapping
    public void saveNewPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.saveNewPessoa(pessoa);
    }
}

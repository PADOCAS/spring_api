/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldsystems.api.controller;

import com.ldsystems.api.model.Pessoa;
import com.ldsystems.api.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "jdbc")
    public List<Pessoa> getListPessoasJdbc() {
        return pessoaService.getListPessoasJdbc();
    }

    //É respeitada a hierarquia dos pacotes, colocar os controller como pacotes filhos da API!
    //HTTP GET > Retorna lista de Pessoa
    @GetMapping
    public List<Pessoa> getListPessoas() {
        return pessoaService.getListPessoas();
    }
    
    ///HTTP GET > Retorna uma Pessoa, caso encontrar o ID pesquisado
    @GetMapping(path = "{PessoaID}")
    public Pessoa getPessoaPorId(@PathVariable("PessoaID") Long id) {
        return pessoaService.getPessoaPorId(id);
    }

    //Salva um novo registro de Pessoa (HTTP POST)
    //Recebe um JSON de Pessoa
    @PostMapping
    public void saveNewPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.saveNewPessoa(pessoa);
    }

    //Delete para remover uma Pessoa através do ID
    @DeleteMapping(path = "{PessoaID}")
    public void removePessoa(@PathVariable("PessoaID") Long id) {
        pessoaService.removePessoa(id);
    }

    //Put para Atualizar uma Pessoa através do ID (nome ou email)
    //Nome e Email não são requeridos, pode ser informado apenas um deles!
    @PutMapping(path = "{PessoaID}")
    public void updatePessoa(
            @PathVariable("PessoaID") Long id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email) {
        pessoaService.updatePessoa(id, nome, email);
    }
}

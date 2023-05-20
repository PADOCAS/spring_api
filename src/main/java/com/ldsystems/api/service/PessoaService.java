/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldsystems.api.service;

import com.ldsystems.api.model.Pessoa;
import com.ldsystems.api.repository.PessoaRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * Método utilizado no http get - retorna lista de Pessoas cadastradas
     *
     * @return
     */
    public List<Pessoa> getListPessoas() {
        return pessoaRepository.findAll();
    }

    /**
     * Método utilizado no http post - salva um novo registro de Pessoa
     *
     * @param pessoa
     */
    public void saveNewPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            Optional<Pessoa> opPessoaByEmail = pessoaRepository.findPessoaByEmail(pessoa.getEmail());

            if (opPessoaByEmail.isPresent()) {
                throw new IllegalStateException("Já existe esse email cadastrado.");
            }

            pessoaRepository.save(pessoa);
        }
    }

    /**
     * Método utilizado no http delete - remove uma pessoa através do ID
     *
     * @param id
     */
    public void removePessoa(Long id) {
        if (id != null) {
            if (!pessoaRepository.existsById(id)) {
                throw new IllegalStateException("Pessoa(" + id + ") não existe.");
            }

            pessoaRepository.deleteById(id);
        }
    }

    /**
     * Método para atualizar Pessoa, a anotação transactional serve para tornar
     * o objeto Pessoa gerenciável, ele vai atualizar os dados no banco de dados
     * automaticamente através dos set que vamos fazendo aqui!
     *
     * @param id
     * @param nome
     * @param email
     */
    @Transactional
    public void updatePessoa(Long id, String nome, String email) {
        if (id != null) {
            if ((nome != null
                    && !nome.isEmpty())
                    || (email != null
                    && !email.isEmpty())) {
                //OrElseThrow retorna o objeto pessoa caso encontre!
                Pessoa pessoa = pessoaRepository.findById(id)
                        .orElseThrow(() -> new IllegalStateException("Pessoa(" + id + ") não existe."));

                if (nome != null
                        && !nome.isEmpty()
                        && !Objects.equals(nome, pessoa.getNome())) {
                    pessoa.setNome(nome);
                }

                if (email != null
                        && !email.isEmpty()
                        && !Objects.equals(email, pessoa.getEmail())) {
                    //Verifica se o email já não existe:
                    Optional<Pessoa> opPessoaByEmail = pessoaRepository.findPessoaByEmail(email);

                    if (opPessoaByEmail.isPresent()) {
                        throw new IllegalStateException("Já existe esse email cadastrado.");
                    }

                    pessoa.setEmail(email);
                }
            } else {
                throw new IllegalStateException("Para atualizar uma Pessoa, informe um nome ou email.");
            }
        }
    }
}

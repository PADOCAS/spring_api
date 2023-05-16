/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldsystems.api.service;

import com.ldsystems.api.model.Pessoa;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
//Nesse caso vamos usar a anotação service, funciona tal qual a @Component... no caso como essa classe é um service vamos usa-la
@Service
public class PessoaService {

    public List<Pessoa> getListPessoas() {
        List<Pessoa> listPessoa = new ArrayList<>();
        listPessoa.add(new Pessoa(
                "André",
                "andre@bol.com.br",
                LocalDate.of(1983, Month.MARCH, 12)));
        listPessoa.add(new Pessoa(
                "Roberto Andrada",
                "robgol@gmail.com.br",
                LocalDate.of(1995, Month.SEPTEMBER, 17)));

        return listPessoa;
    }
}

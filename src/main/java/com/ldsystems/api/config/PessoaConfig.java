/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldsystems.api.config;

import com.ldsystems.api.model.Pessoa;
import com.ldsystems.api.repository.PessoaRepository;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração, para rodar assim que subir nossa aplicação, alimentando alguns dados na tabela Pessoa
 * 
 * @author bique
 */
@Configuration
public class PessoaConfig {

    @Bean
    CommandLineRunner commandLineRunner(PessoaRepository pessoaRepository) {
        return args -> {
            Pessoa andre = new Pessoa(
                    1L,
                    "André",
                    "andre@bol.com.br",
                    LocalDate.of(1983, Month.MARCH, 12));

            Pessoa roberto = new Pessoa(
                    2L,
                    "Roberto Andrada",
                    "robgol@gmail.com.br",
                    LocalDate.of(1995, Month.SEPTEMBER, 17));

            pessoaRepository.saveAll(List.of(andre, roberto));
        };
    }
}

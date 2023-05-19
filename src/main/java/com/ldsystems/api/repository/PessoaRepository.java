/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ldsystems.api.repository;

import com.ldsystems.api.model.Pessoa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bique
 */

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
    /**
     * Método para verificar se já existe alguma Pessoa com esse email cadastrada!
     * @param email
     * @return 
     */
    @Query("SELECT p FROM Pessoa p WHERE p.email = ?1")
    Optional<Pessoa> findPessoaByEmail(String email);
}

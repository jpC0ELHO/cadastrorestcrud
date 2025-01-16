package com.crudpessoas.cadastro.domain.repositories;

import com.crudpessoas.cadastro.domain.entities.Endereco;
import com.crudpessoas.cadastro.domain.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelefoneRepository extends JpaRepository<Telefone, String> {
    Optional<Telefone>findByNumber(String number);
}

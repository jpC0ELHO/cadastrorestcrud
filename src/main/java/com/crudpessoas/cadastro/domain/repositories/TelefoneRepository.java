package com.crudpessoas.cadastro.domain.repositories;

import com.crudpessoas.cadastro.domain.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Endereco, String> {
}

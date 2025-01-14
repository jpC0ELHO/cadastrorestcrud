package com.crudpessoas.cadastro.api.services.pessoaJuridica;

import com.crudpessoas.cadastro.api.dtos.PessoaJuridicaRequest;
import com.crudpessoas.cadastro.api.dtos.PessoaJuridicaResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PessoaJuridicaService {
    List<PessoaJuridicaResponse>findCnpjList();
    Optional<PessoaJuridicaResponse>findById(UUID uuid);
    void creatCnpj(PessoaJuridicaRequest pessoaJuridicaRequest);
    void updateCnpj(UUID uuid,PessoaJuridicaRequest pessoaJuridicaRequest);
    void deleteCnpj(UUID uuid);
}

package com.crudpessoas.cadastro.api.services.Endereco;

import com.crudpessoas.cadastro.api.dtos.EnderecoRequest;
import com.crudpessoas.cadastro.api.dtos.EnderecoResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnderecoService {
    List<EnderecoResponse>findEnderecoList();
    Optional<EnderecoResponse>findEnderecoCep(String cep);
    void createEndereco(EnderecoRequest enderecoRequest);
    void updateEndereco(String cep,EnderecoRequest enderecoRequest);
    void deleteEndereco(String cep);
}

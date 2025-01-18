package com.crudpessoas.cadastro.api.services.Telefone;

import com.crudpessoas.cadastro.api.dtos.TelefoneRequest;
import com.crudpessoas.cadastro.api.dtos.TelefoneResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TelefoneService {
    List<TelefoneResponse>findeTelefoneList();
    Optional<TelefoneResponse>findTelefoneId(UUID uuid);
    void createTelefone(TelefoneRequest telefoneRequest);
    void updateTelefoe(UUID uuid, TelefoneRequest telefoneRequest);
    void deleteTelefone(UUID uuid);
}

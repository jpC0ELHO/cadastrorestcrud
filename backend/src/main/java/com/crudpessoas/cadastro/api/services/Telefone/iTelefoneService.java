package com.crudpessoas.cadastro.api.services.Telefone;


import com.crudpessoas.cadastro.api.dtos.TelefoneRequest;
import com.crudpessoas.cadastro.api.dtos.TelefoneResponse;
import com.crudpessoas.cadastro.domain.exceptions.ModelIntegrityViolationException;
import com.crudpessoas.cadastro.domain.exceptions.TelefoneNotFoundException;
import com.crudpessoas.cadastro.domain.repositories.TelefoneRepository;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.crudpessoas.cadastro.api.dtos.TelefoneRequest.toEntidade;
import static com.crudpessoas.cadastro.api.dtos.TelefoneResponse.toResponse;

@Service
@AllArgsConstructor
@Log4j2
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class iTelefoneService implements TelefoneService{

    private final TelefoneRepository telefoneRepository;

    @Override
    public List<TelefoneResponse> findeTelefoneList() {
        try {
            var findTelefone=telefoneRepository.findAll();
            if (findTelefone.isEmpty()){
                throw new TelefoneNotFoundException("List not found!");
            }
            return findTelefone.stream().map(TelefoneResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error :{} !",e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<TelefoneResponse> findTelefoneId(UUID uuid) {
        var findTelefoneId=telefoneRepository.findById(uuid);
        if (findTelefoneId.isEmpty()){
            log.error("ID : {} not found!",uuid);
            throw new TelefoneNotFoundException("ID not found!");
        }
        return findTelefoneId.map(TelefoneResponse::toResponse);
    }

    @Override
    public void createTelefone(TelefoneRequest telefoneRequest) {
        var findTelefoneNumber=telefoneRepository.findByNumber(telefoneRequest.number());
        if (findTelefoneNumber.isPresent()){
            log.error("Telefone number:{}  alerady exists",telefoneRequest.number());
            throw new ModelIntegrityViolationException("Integrity violation!");
        }
        telefoneRepository.save(toEntidade(telefoneRequest));
    }

    @Override
    public void updateTelefoe(UUID uuid, TelefoneRequest telefoneRequest) {
        var findeTelefoneById=telefoneRepository.findById(uuid);
        if (findeTelefoneById.isEmpty()){
            log.error("ID :{} not found!",uuid);
            throw new TelefoneNotFoundException("ID not found!");
        }
        findeTelefoneById.map(telefone -> {
            telefone.setNumber(telefoneRequest.number());
            telefone.setTelefoneTipo(telefoneRequest.telefoneTipo());
            return telefoneRepository.save(telefone);
        });
    }

    @Override
    public void deleteTelefone(UUID uuid) {
        try {
            var findTelefoneId=telefoneRepository
                    .findById(uuid)
                    .orElseThrow(()-> new TelefoneNotFoundException("ID not found!"));
            telefoneRepository.delete(findTelefoneId);
        }catch (RuntimeException e){
            log.error("Error: {} !",e.getMessage());
        }
    }
}

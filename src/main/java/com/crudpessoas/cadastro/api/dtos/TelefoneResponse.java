package com.crudpessoas.cadastro.api.dtos;

import com.crudpessoas.cadastro.domain.entities.Telefone;
import com.crudpessoas.cadastro.domain.entities.enums.TelefoneTipo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"number","telefoneTipo"})
public record TelefoneResponse(
        String number,
        TelefoneTipo telefoneTipo
) {
    public static TelefoneResponse toResponse(Telefone telefone){
        if (telefone==null){
            return null;
        }
        return new TelefoneResponse(
                telefone.getNumber(),
                telefone.getTelefoneTipo()
        );
    }
}

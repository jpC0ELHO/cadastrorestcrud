package com.crudpessoas.cadastro.api.dtos;

import com.crudpessoas.cadastro.domain.entities.Endereco;
import com.crudpessoas.cadastro.domain.entities.enums.Estado;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record EnderecoRequest(
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        @NotBlank
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        @NotNull
        Estado estado,
        @NotBlank
        String cep
) {
    public static Endereco toEntidade(EnderecoRequest enderecoRequest){
        if (enderecoRequest==null){
            return null;
        }
        return new Endereco(
                enderecoRequest.logradouro(),
                enderecoRequest.numero(),
                enderecoRequest.complemento(),
                enderecoRequest.bairro(),
                enderecoRequest.cidade(),
                enderecoRequest.estado(),
                enderecoRequest.cep()
        );
    }
}

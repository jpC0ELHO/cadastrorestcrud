package com.crudpessoas.cadastro.api.dtos;

import com.crudpessoas.cadastro.domain.entities.Endereco;
import com.crudpessoas.cadastro.domain.entities.enums.Estado;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"cep","logradouro","numero"
        ,"complemento","bairro","cidade","estado"})
public record EnderecoResponse(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        Estado estado,
        String cep
) {
    public static EnderecoResponse toResponse(Endereco endereco){
        if (endereco==null){
            return null;
        }
        return new EnderecoResponse(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getEstado(),
                endereco.getCep()
        );
    }
}

package com.crudpessoas.cadastro.api.dtos;


import com.crudpessoas.cadastro.domain.entities.Endereco;
import com.crudpessoas.cadastro.domain.entities.PessoaJuridica;
import com.crudpessoas.cadastro.domain.entities.Telefone;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PessoaJuridicaRequest(
        @NotBlank
        String cnpj,
        @NotBlank
        String razaoSocial,
        @NotBlank
        String nomeFantasia,
        @NotBlank
        String responsavel,
        @NotNull
        @NotBlank
        Set<String> email,
        @NotNull
        Set<Telefone> telefone,
        @NotBlank
        String status,
        @Embedded
        @NotNull
        Endereco endereco
) {
    public static PessoaJuridica toEntidade(PessoaJuridicaRequest pessoaJuridicaRequest){
        if (pessoaJuridicaRequest==null){
            return null;
        }
        return new PessoaJuridica(
                pessoaJuridicaRequest.cnpj(),
                pessoaJuridicaRequest.razaoSocial(),
                pessoaJuridicaRequest.nomeFantasia(),
                pessoaJuridicaRequest.responsavel(),
                pessoaJuridicaRequest.email(),
                pessoaJuridicaRequest.telefone(),
                pessoaJuridicaRequest.status(),
                pessoaJuridicaRequest.endereco()
        );
    }
}

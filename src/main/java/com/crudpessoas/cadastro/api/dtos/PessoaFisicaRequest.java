package com.crudpessoas.cadastro.api.dtos;

import com.crudpessoas.cadastro.domain.entities.PessoaFisica;
import com.crudpessoas.cadastro.domain.entities.Telefone;
import com.crudpessoas.cadastro.domain.entities.enums.Sexo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PessoaFisicaRequest (
        @NotBlank
        String cpf,
        @NotBlank
        String rg,
        @NotBlank
        String primeiroNome,
        @NotBlank
        String sobrenome,
        @NotNull
        @NotBlank
        Sexo sexo,
        @NotNull
        @NotBlank
        Set<String> emails,
        @NotNull
        Set<Telefone> telefones,
        @NotNull
        LocalDate dataNascimento
){
    public static PessoaFisicaRequest toEntidade(PessoaFisica pessoaFisica){
            if (pessoaFisica==null){
                    return null;
            }
            return new PessoaFisicaRequest(
                    pessoaFisica.getCpf(),
                    pessoaFisica.getRg(),
                    pessoaFisica.getPrimeiroNome(),
                    pessoaFisica.getSobrenome(),
                    pessoaFisica.getSexo(),
                    pessoaFisica.getEmails(),
                    pessoaFisica.getTelefones(),
                    pessoaFisica.getDataNascimento()
            );
    }
}

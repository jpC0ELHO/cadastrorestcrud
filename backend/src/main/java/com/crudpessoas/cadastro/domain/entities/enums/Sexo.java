package com.crudpessoas.cadastro.domain.entities.enums;

import lombok.Getter;

@Getter
public enum Sexo {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    NAOINFORM("PREFIRO NAO DIZER"),
    OUTRO("OUTRO");
    private final String nome;
    Sexo(String nome){
        this.nome=nome;
    }
}

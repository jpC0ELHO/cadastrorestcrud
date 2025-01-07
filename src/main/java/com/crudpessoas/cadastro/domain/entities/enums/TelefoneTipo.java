package com.crudpessoas.cadastro.domain.entities.enums;

import lombok.Getter;

@Getter
public enum TelefoneTipo {
    PESSOAL("PESSOAL"),
    RESIDENCIAL("RESIDENCIAL"),
    POLICIA("190"),
    SAMU("192"),
    BOMBEIROS("193"),
    OUTROS("OUTROS");

    private String name;

    TelefoneTipo(String name){
        this.name=name;
    }
}

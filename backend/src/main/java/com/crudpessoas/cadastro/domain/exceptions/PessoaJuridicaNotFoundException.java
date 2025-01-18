package com.crudpessoas.cadastro.domain.exceptions;

import lombok.Getter;

@Getter
public class PessoaJuridicaNotFoundException extends ModelNotFoundException{
    public PessoaJuridicaNotFoundException(String message){
        super(message);
    }
    public PessoaJuridicaNotFoundException(){
        super("CNPJ not found!");
    }
}

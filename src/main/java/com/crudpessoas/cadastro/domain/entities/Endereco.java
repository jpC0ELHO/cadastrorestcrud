package com.crudpessoas.cadastro.domain.entities;

import com.crudpessoas.cadastro.domain.entities.enums.Estado;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Endereco {

    @Column(nullable = false, unique = false, length = 100)
    private String logradouro;
    @Column(nullable = false, unique = false, length = 10)
    private String numero;
    @Column(nullable = false, unique = false, length = 100 )
    private String complemento;
    @Column(nullable = false, unique = false, length = 100 )
    private String bairro;
    @Column(nullable = false, unique = false, length = 100)
    private String cidade;
    @Column(nullable = false, unique = false, length = 20)
    private Estado estado;
    @NotNull
    @NotBlank
    @Column(nullable = false, unique = false, length = 10)
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O campo 'cep' deve ter o formato '12345-678'")
    private String cep;
}

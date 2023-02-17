package com.company.api.fornecedores;

import jakarta.validation.constraints.NotNull;

public record ForUpdateDTO(@NotNull Long id,
                           String nome,
                           String cnpj,
                           String cidade,
                           String estado,
                           String email) {

    public ForUpdateDTO(FornecedorEntity json){

        this(json.getId(), json.getNome(), json.getCnpj(),
                json.getCidade(), json.getEstado(), json.getEmail());

    }

}

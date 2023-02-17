package com.company.api.funcionarios;

import jakarta.validation.constraints.NotNull;

public record FunUpdateDTO(@NotNull Long id,
                           String nome,
                           String idade,
                           String dinicio,
                           String salario,
                           Funcao funcao) {

    public FunUpdateDTO(FuncionarioEntity json){

        this(json.getId(), json.getNome(), json.getIdade(), json.getDinicio(), json.getSalario(), json.getFuncao());

    }


}

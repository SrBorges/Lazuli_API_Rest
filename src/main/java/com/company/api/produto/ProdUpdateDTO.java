package com.company.api.produto;

import jakarta.validation.constraints.NotNull;

public record ProdUpdateDTO(@NotNull Long id,
                            String nome,
                            Tipo tipo,
                            String fornecedor,
                            String quantidade,
                            String lote,
                            String custo) {

    public ProdUpdateDTO(ProdutoEntity json){

        this(json.getId(), json.getNome(), json.getTipo(), json.getFornecedor(),
                json.getQuantidade(), json.getLote(), json.getCusto());

    }


}

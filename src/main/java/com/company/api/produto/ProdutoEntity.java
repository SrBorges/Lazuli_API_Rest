package com.company.api.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produto")
@Entity(name = "ProdutoEntity")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class ProdutoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull @NotBlank
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String fornecedor;
    private String quantidade;
    private String lote;
    private String custo;


    public ProdutoEntity(ProdutoEntity json) {

        this.nome = json.nome;
        this.tipo = json.tipo;
        this.fornecedor = json.fornecedor;
        this.quantidade = json.quantidade;
        this.lote = json.lote;
        this.custo = json.custo;

    }

    public void updateInfo(ProdUpdateDTO json) {

        if(json.nome() != null){
            this.nome = json.nome();
        }

        if(json.tipo() != null){
            this.tipo = json.tipo();
        }

        if(json.fornecedor() != null){
            this.fornecedor = json.fornecedor();
        }

        if(json.quantidade() != null){
            this.quantidade = json.quantidade();
        }

        if(json.lote() != null){
            this.lote = json.lote();
        }

        if(json.custo() != null){
            this.custo = json.custo();
        }

    }
}

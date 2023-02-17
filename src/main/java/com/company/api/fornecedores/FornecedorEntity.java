package com.company.api.fornecedores;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "fornecedores")
@Entity(name = "FornecedorEntity")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class FornecedorEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull @NotBlank
    private String nome;
    private String cnpj;
    private String cidade;
    private String estado;
    @NotNull @Email
    private String email;

    public FornecedorEntity(FornecedorEntity json) {

        this.nome = json.nome;
        this.cnpj = json.cnpj;
        this.cidade = json.cidade;
        this.estado = json.estado;
        this.email = json.email;

    }

    public void updateInfo(ForUpdateDTO json) {

        if(json.nome() != null){
            this.nome = json.nome();
        }

        if(json.cnpj() != null){
            this.cnpj = json.cnpj();
        }

        if(json.cidade() != null){
            this.cidade = json.cidade();
        }

        if(json.estado() != null){
            this.estado = json.estado();
        }

        if(json.email() != null){
            this.email = json.email();
        }

    }
}

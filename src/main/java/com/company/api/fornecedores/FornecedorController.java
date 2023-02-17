package com.company.api.fornecedores;

import com.company.api.produto.ProdUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController

@RequestMapping("/fornecedores")

public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid FornecedorEntity json, UriComponentsBuilder UriBuilder){

        var fornecedor = repository.save(new FornecedorEntity(json));

        var uri = UriBuilder.path("/fornecedores/{id}").buildAndExpand(fornecedor.getId()).toUri();

        return ResponseEntity.created(uri).body(new FornecedorDTO(fornecedor));

    }

    @GetMapping
    public Page<FornecedorDTO> read(Pageable page){

        return repository.findAll(page).map(FornecedorDTO::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ForUpdateDTO json){

        var fornecedor = repository.getReferenceById(json.id());

        fornecedor.updateInfo(json);

        return ResponseEntity.ok(new ForUpdateDTO(fornecedor));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){

        var fornecedor = repository.getReferenceById(id);

        return ResponseEntity.ok(new ForUpdateDTO(fornecedor));

    }


}

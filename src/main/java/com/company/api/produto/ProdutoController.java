package com.company.api.produto;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController

@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ProdutoEntity json, UriComponentsBuilder UriBuilder){

        var produto = repository.save(new ProdutoEntity(json));

        var uri = UriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProdutoDTO(produto));

    }

    @GetMapping
    public Page<ProdutoDTO> read(Pageable page){

        return repository.findAll(page).map(ProdutoDTO::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ProdUpdateDTO json){

        var produto = repository.getReferenceById(json.id());

        produto.updateInfo(json);

        return ResponseEntity.ok(new ProdUpdateDTO(produto));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){

        var produto = repository.getReferenceById(id);

        return ResponseEntity.ok(new ProdutoDTO(produto));

    }

}

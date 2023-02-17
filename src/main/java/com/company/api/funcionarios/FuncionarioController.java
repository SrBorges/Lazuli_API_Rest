package com.company.api.funcionarios;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController

@RequestMapping("/funcionarios")

public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid FuncionarioEntity json, UriComponentsBuilder UriBuilder){

        var funcionario = repository.save(new FuncionarioEntity(json));

        var uri = UriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));

    }

    @GetMapping
    public Page<FuncionarioDTO> read(Pageable page){

        return repository.findAll(page).map(FuncionarioDTO::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid FunUpdateDTO json){

        var funcionario = repository.getReferenceById(json.id());

        funcionario.updateInfo(json);

        return ResponseEntity.ok(new FunUpdateDTO(funcionario));


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){

        var funcinario = repository.getReferenceById(id);

        return ResponseEntity.ok(new FuncionarioDTO(funcinario));

    }




}

package com.company.api.usuarios;

import com.company.api.infra.DadosTokenJWT;
import com.company.api.infra.TokenServc;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/login")

public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenServc tokenServc;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid CheckDTO json){

        var authenticationToken = new UsernamePasswordAuthenticationToken(json.login(), json.senha());

        var auth = manager.authenticate(authenticationToken);

        var tokenJWT = tokenServc.gerarToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }

}

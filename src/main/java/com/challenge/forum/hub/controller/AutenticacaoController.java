package com.challenge.forum.hub.controller;

import com.challenge.forum.hub.entidades.usuario.AutenticaDados;
import com.challenge.forum.hub.entidades.usuario.Usuario;
import com.challenge.forum.hub.security.TokenService;
import com.challenge.forum.hub.security.dadosTokenJWT;
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

    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AutenticaDados dados) {
        var autToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(autToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new dadosTokenJWT(tokenJWT));
    }
}
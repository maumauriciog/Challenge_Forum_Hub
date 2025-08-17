package com.challenge.forum.hub.controller;

import com.challenge.forum.hub.entidades.Topico;
import com.challenge.forum.hub.forum.DadosCadastroForum;
import com.challenge.forum.hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class ForumController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    //por se tratar de inserção no banco de dados, ela deve ser do tipo transação
    @Transactional
    public void CadastrarTopico(@RequestBody DadosCadastroForum dadosCadastroForum) {
        repository.save(new Topico(dadosCadastroForum));
    }
}

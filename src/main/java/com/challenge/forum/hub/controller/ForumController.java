package com.challenge.forum.hub.controller;

import com.challenge.forum.hub.entidades.Topico;
import com.challenge.forum.hub.forum.DadosCadastroForum;
import com.challenge.forum.hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class ForumController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void CadastrarTopico(@RequestBody @Valid DadosCadastroForum dadosCadastroForum) {
        repository.save(new Topico(dadosCadastroForum));
        System.out.println(dadosCadastroForum);
    }

    @GetMapping
    public Page<Topico> listarTopicos(@PageableDefault(size = 10,  sort = {"datacriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        return repository.findAll(paginacao);
    }
}
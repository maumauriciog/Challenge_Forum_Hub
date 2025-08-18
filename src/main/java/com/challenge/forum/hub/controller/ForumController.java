package com.challenge.forum.hub.controller;

import com.challenge.forum.hub.entidades.Topico;
import com.challenge.forum.hub.forum.DadosAtualizacoesForum;
import com.challenge.forum.hub.forum.DadosCadastroForum;
import com.challenge.forum.hub.forum.DetalhamentoTopico;
import com.challenge.forum.hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class ForumController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity CadastrarTopico(@RequestBody @Valid DadosCadastroForum dadosCadastroForum, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dadosCadastroForum);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity <Page<Topico>> ListarTopicos(@PageableDefault(size = 10, sort = {"datacriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = repository.findAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity ListagemDetalhada(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity AtualizarTopicos(@RequestBody @Valid DadosAtualizacoesForum dadosAtualizacoesForum) {
        var topico = repository.getReferenceById(dadosAtualizacoesForum.id());
        topico.atualizarInformacoes(dadosAtualizacoesForum);

        return ResponseEntity.ok(new DetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Excluir(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.notFound().build();
    }
}
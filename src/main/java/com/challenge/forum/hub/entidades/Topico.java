package com.challenge.forum.hub.entidades;

import com.challenge.forum.hub.forum.Curso;
import com.challenge.forum.hub.forum.DadosAtualizacoesForum;
import com.challenge.forum.hub.forum.DadosCadastroForum;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Table(name = "topicos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "titulo", "mensagem"})
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private String datacriacao;
    private String estadotopico;
    private String autor;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DadosCadastroForum dadosCadastroForum) {
        this.titulo = dadosCadastroForum.titulo();
        this.mensagem = dadosCadastroForum.mensagem();
        this.datacriacao = dadosCadastroForum.datacriacao();
        this.estadotopico = dadosCadastroForum.estadotopico();
        this.autor = dadosCadastroForum.autor();
        this.curso = dadosCadastroForum.curso();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacoesForum dadosAtualizacoesForum) {
        this.titulo = dadosAtualizacoesForum.titulo();
        this.mensagem = dadosAtualizacoesForum.mensagem();
        this.datacriacao = dadosAtualizacoesForum.datacriacao();
        this.estadotopico = dadosAtualizacoesForum.estadotopico();
        this.autor = dadosAtualizacoesForum.autor();
        this.curso = dadosAtualizacoesForum.curso();
    }
}

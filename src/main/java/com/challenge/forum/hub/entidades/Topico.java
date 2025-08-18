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
        if (dadosAtualizacoesForum.titulo() != null) {
            this.titulo = dadosAtualizacoesForum.titulo();
        }
        if (dadosAtualizacoesForum.mensagem() != null) {
            this.mensagem = dadosAtualizacoesForum.mensagem();
        }
        if (dadosAtualizacoesForum.datacriacao() != null) {
            this.datacriacao = dadosAtualizacoesForum.datacriacao();
        }
        if (dadosAtualizacoesForum.estadotopico() != null) {
            this.estadotopico = dadosAtualizacoesForum.estadotopico();
        }
        if (dadosAtualizacoesForum.autor() != null) {
            this.autor = dadosAtualizacoesForum.autor();
        }
        if (dadosAtualizacoesForum.curso() != null) {
            this.curso = dadosAtualizacoesForum.curso();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public String getEstadotopico() {
        return estadotopico;
    }

    public void setEstadotopico(String estadotopico) {
        this.estadotopico = estadotopico;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

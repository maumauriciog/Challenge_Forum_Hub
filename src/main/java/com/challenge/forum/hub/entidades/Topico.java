package com.challenge.forum.hub.entidades;

import com.challenge.forum.hub.forum.Curso;
import com.challenge.forum.hub.forum.DadosCadastroForum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "topicos")
//cria os métodos get e setters
@Getter
@Setter
//cria um construtor sem argumentos
@NoArgsConstructor
//cria um construtor com argumentos necessário
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
}

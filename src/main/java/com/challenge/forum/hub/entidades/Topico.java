package com.challenge.forum.hub.entidades;

import com.challenge.forum.hub.forum.Curso;
import com.challenge.forum.hub.forum.DadosCadastroForum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "topicos")
//cria os métodos get e setters
@Getter @Setter
//cria um construtor sem argumentos
@NoArgsConstructor
//cria um construtor com argumentos necessário
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menssagem;

    @Enumerated(EnumType.STRING)
    private Curso curso;
    private String titulo;

    public Topico(DadosCadastroForum dadosCadastroForum) {
        this.menssagem = dadosCadastroForum.menssagem();
        this.curso = dadosCadastroForum.curso();
        this.titulo = dadosCadastroForum.titulo();

    }
}

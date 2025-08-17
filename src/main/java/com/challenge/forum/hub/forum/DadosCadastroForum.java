package com.challenge.forum.hub.forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroForum(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String datacriacao,
        @NotBlank
        String estadotopico,
        @NotBlank
        String autor,
        @NotNull
        Curso curso) {

    @Override
    public String toString() {
        return "\n-> Título: " + titulo + "\n" +
                "-> Mensagem: " + mensagem + "\n" +
                "-> Data Criação: " + datacriacao + "\n" +
                "-> Estado do Tópico: " + estadotopico + "\n" +
                "-> Autor: " + autor + "\n" +
                "-> Curso: " + curso + "\n";
    }
}
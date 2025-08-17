package com.challenge.forum.hub.forum;

public record DadosCadastroForum(
        String titulo,
        String mensagem,
        String datacriacao,
        String estadotopico,
        String autor,
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
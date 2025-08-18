package com.challenge.forum.hub.forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacoesForum(
        @NotNull
        Long id,
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
        Curso curso
) {
}

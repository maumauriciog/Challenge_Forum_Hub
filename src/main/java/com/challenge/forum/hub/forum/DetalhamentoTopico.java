package com.challenge.forum.hub.forum;

import com.challenge.forum.hub.entidades.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String datacriacao,
        String estadotopico,
        String autor,
        Curso curso
) {

    public DetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDatacriacao(), topico.getEstadotopico(), topico.getAutor(), topico.getCurso());
    }
}
package com.foro.foroHub.domain.topico;

import com.foro.foroHub.domain.model.DatosTopico;

import java.time.LocalDateTime;

public record ListaDatosTopico(Long id, String titulo, String mensaje, LocalDateTime date) {

    public ListaDatosTopico(DatosTopico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getDate());
    }
}

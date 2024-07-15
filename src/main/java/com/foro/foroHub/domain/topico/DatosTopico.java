package com.foro.foroHub.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosTopico(
                             @NotBlank String titulo,
                             @NotBlank String mensaje,
                             LocalDateTime date,
                             @NotBlank String curso,
                             @NotBlank String autor) {
}
package com.foro.foroHub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRespuestaTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String curso,
        @NotBlank String autor) {
}

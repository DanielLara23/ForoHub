package com.foro.foroHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualiszarTopico(@NotNull Long id,
                                     String titulo,
                                     String mensaje) {
}

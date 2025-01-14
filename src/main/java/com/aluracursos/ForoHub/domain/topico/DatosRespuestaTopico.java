package com.aluracursos.ForoHub.model;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String curso
) {
}

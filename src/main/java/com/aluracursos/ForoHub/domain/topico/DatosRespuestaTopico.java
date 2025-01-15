package com.aluracursos.ForoHub.domain.topico;

import com.aluracursos.ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String nombreUsuario,
        String curso
) {

    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getUsuario().getNombre(),
                topico.getCurso());
    }

}

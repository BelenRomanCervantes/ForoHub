package com.aluracursos.ForoHub.domain.topico;

import com.aluracursos.ForoHub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Usuario usuario,
        @NotBlank
        String curso
) {
}

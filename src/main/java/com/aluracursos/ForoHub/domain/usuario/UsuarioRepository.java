package com.aluracursos.ForoHub.domain.usuario;

import com.aluracursos.ForoHub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
}

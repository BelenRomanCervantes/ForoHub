package com.aluracursos.ForoHub.domain.usuario;

import com.aluracursos.ForoHub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    UserDetails findByUsername(String username);
}

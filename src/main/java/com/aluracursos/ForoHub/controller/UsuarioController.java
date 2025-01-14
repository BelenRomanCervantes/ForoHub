package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.domain.topico.DatosRegistroTopico;
import com.aluracursos.ForoHub.domain.topico.DatosRespuestaTopico;
import com.aluracursos.ForoHub.domain.topico.Topico;
import com.aluracursos.ForoHub.domain.usuario.DatosRegistroUsuario;
import com.aluracursos.ForoHub.domain.usuario.Usuario;
import com.aluracursos.ForoHub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @RequestMapping("/registro")
    private ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroUsuario datosRegistro){
        usuarioRepository.save(new Usuario(datosRegistro));
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

}

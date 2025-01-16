package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.domain.usuario.DatosRegistroUsuario;
import com.aluracursos.ForoHub.domain.usuario.Usuario;
import com.aluracursos.ForoHub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @RequestMapping("/registro")
    private ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroUsuario datosRegistro){
        // Cifrar la contraseña
        String passwordCifrada = passwordEncoder.encode(datosRegistro.password());
        usuarioRepository.save(new Usuario(datosRegistro, passwordCifrada));
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

}

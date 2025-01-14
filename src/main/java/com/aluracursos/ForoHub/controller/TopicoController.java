package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.domain.topico.DatosRegistroTopico;
import com.aluracursos.ForoHub.domain.topico.DatosRespuestaTopico;
import com.aluracursos.ForoHub.domain.topico.Topico;
import com.aluracursos.ForoHub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foro")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Registro de nuevo topico
    @PostMapping
    @RequestMapping("/registro")
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistro){
        Topico topico = topicoRepository.save(new Topico(datosRegistro));
        DatosRespuestaTopico datosRespuesta = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getFechaCreacion(), topico.getCurso());
        return ResponseEntity.ok(datosRespuesta);
    }

    // Listado de topicos
    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosRespuestaTopico::new));
    }

    // Buscar un topico por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaMedico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getCurso());
        return ResponseEntity.ok(datosRespuestaTopico);
    }
}

package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.domain.topico.*;
import jakarta.transaction.Transactional;
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
                topico.getMensaje(), topico.getFechaCreacion(), topico.getUsuario().getNombre(), topico.getCurso());
        return ResponseEntity.ok(datosRespuesta);
    }

    // Listado de topicos
    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByStatusActivo(paginacion).map(DatosRespuestaTopico::new));
    }

    // Buscar un topico por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> buscarTopico(@PathVariable Long id) {
        var topicoEncontrado = topicoRepository.findById(id);
        if (topicoEncontrado.isPresent()){
            var topico = topicoEncontrado.get();
            var datosRespuesta = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                    topico.getFechaCreacion(), topico.getUsuario().getNombre(), topico.getCurso());
            return ResponseEntity.ok(datosRespuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar topico
    @PutMapping("/actualizar")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        var topicoEncontrado = topicoRepository.findById(datosActualizarTopico.id());
        if (topicoEncontrado.isPresent()){
            var topico = topicoEncontrado.get();
            topico.actualizarDatos(datosActualizarTopico);
             var datosRespuesta = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                    topico.getFechaCreacion(), topico.getUsuario().getNombre(), topico.getCurso());
             return ResponseEntity.ok(datosRespuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Borrar topico
    @DeleteMapping("/borrar/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        var topicoEncontrado = topicoRepository.findById(id);
        if (topicoEncontrado.isPresent()){
        topicoRepository.deleteById(id);
        return ResponseEntity.ok("Topico eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }

    }


}

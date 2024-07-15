package com.foro.foroHub.controller;

import com.foro.foroHub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosTopico datosTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        com.foro.foroHub.domain.model.DatosTopico topico = topicoRepository.save(new com.foro.foroHub.domain.model.DatosTopico(datosTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getAutor());
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<ListaDatosTopico>> listaDatosTopicos(Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(ListaDatosTopico::new));
    }


    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualiszarTopico datosActualiszarTopico){
        com.foro.foroHub.domain.model.DatosTopico topico = topicoRepository.getReferenceById(datosActualiszarTopico.id());
        topico.actualizarTopico(datosActualiszarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getAutor()
                ));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        com.foro.foroHub.domain.model.DatosTopico topico = topicoRepository.getReferenceById(id);

        var datosTopico = new DatosRespuestaTopico(topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getAutor()
        );
        return ResponseEntity.ok(datosTopico);
    }
}

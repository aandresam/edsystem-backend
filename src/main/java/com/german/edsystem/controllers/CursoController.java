package com.german.edsystem.controllers;

import com.german.edsystem.models.Curso;
import com.german.edsystem.service.ICursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/cursos")
public class CursoController {
    private final ICursoService cursoService;

    @GetMapping
    public ResponseEntity<Iterable<Curso>> getCursos() {
        return new ResponseEntity<>(cursoService.getCursos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> getCursoById(@PathVariable("id") Integer id) {
        Optional<Curso> curso = cursoService.getCurso(id);
        if (curso.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.saveCurso(curso), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) {
        Optional<Curso> existingCurso = cursoService.getCurso(curso.getIdCurso());
        if (existingCurso.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingCurso.get().setNombre(curso.getNombre());
        existingCurso.get().setCapacidad(curso.getCapacidad());
        return new ResponseEntity<>(cursoService.saveCurso(existingCurso.get()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteCurso(@PathVariable("id") Integer id) {
        cursoService.deleteCursoById(id);
        return HttpStatus.NO_CONTENT;
    }
}

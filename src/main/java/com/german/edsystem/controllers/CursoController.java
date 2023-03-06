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
        return new ResponseEntity<>(this.cursoService.getCursos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> getCursoById(@PathVariable("id") Integer id) {
        Optional<Curso> curso = this.cursoService.getCurso(id);
        if (curso.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        return new ResponseEntity<>(this.cursoService.createCurso(curso), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) {
        Curso updatedCurso = this.cursoService.updateCurso(curso);
        if (updatedCurso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCurso, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteCurso(@PathVariable("id") Integer id) {
        Optional<Curso> existingCurso = this.cursoService.getCurso(id);
        if (existingCurso.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        cursoService.deleteCursoById(existingCurso.get().getIdCurso());
        return HttpStatus.NO_CONTENT;
    }
}

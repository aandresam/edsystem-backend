package com.german.edsystem.controllers;

import com.german.edsystem.models.Curso;
import com.german.edsystem.service.ICursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cursos")
public class CursoController {
    private final ICursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos() {
        return new ResponseEntity<>(cursoService.getCursos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable("id") Integer id) {
        Curso curso = cursoService.getCurso(id);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.saveCurso(curso), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) {
        Curso existingCurso = cursoService.getCurso(curso.getIdCurso());
        if (existingCurso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingCurso.setNombre(curso.getNombre());
        existingCurso.setCapacidad(curso.getCapacidad());
        return new ResponseEntity<>(cursoService.saveCurso(existingCurso), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCurso(@PathVariable("id") Integer id) {
        cursoService.deleteCursoById(id);
        return HttpStatus.NO_CONTENT;
    }
}

package com.german.edsystem.controllers;

import com.german.edsystem.models.Docente;
import com.german.edsystem.service.IDocenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/docentes")
public class DocenteController {
    private final IDocenteService docenteService;

    @GetMapping
    public ResponseEntity<List<Docente>> getDocentes() {
        return new ResponseEntity<>(docenteService.getDocentes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> getDocente(@PathVariable Integer id) {
        Docente docente = docenteService.getDocente(id);
        if (docente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(docente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Docente> createDocente(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.saveDocente(docente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> updateDocente(@RequestBody Docente docente) {
        Docente existingDocente = docenteService.getDocente(docente.getId());
        if (existingDocente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingDocente.setNombre(docente.getNombre());
        existingDocente.setApellido(docente.getApellido());
        existingDocente.setContacto(docente.getContacto());
        existingDocente.setDomicilio(docente.getDomicilio());
        existingDocente.setFechaNacimiento(docente.getFechaNacimiento());
        return new ResponseEntity<>(docenteService.saveDocente(existingDocente), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDocente(@PathVariable Integer id) {
        docenteService.deleteDocenteById(id);
        return HttpStatus.NO_CONTENT;
    }
}

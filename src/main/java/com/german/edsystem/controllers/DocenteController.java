package com.german.edsystem.controllers;

import com.german.edsystem.models.Docente;
import com.german.edsystem.service.IDocenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/docentes")
public class DocenteController {
    private final IDocenteService docenteService;

    @GetMapping
    public ResponseEntity<Iterable<Docente>> getDocentes() {
        return new ResponseEntity<>(docenteService.getDocentes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Docente>> getDocenteById(@PathVariable Integer id) {
        Optional<Docente> docente = docenteService.getDocente(id);
        if (docente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(docente, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Docente> createDocente(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.saveDocente(docente), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Docente> updateDocente(@RequestBody Docente docente) {
        Optional<Docente> existingDocente = docenteService.getDocente(docente.getId());
        if (existingDocente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingDocente.get().setNombre(docente.getNombre());
        existingDocente.get().setApellido(docente.getApellido());
        existingDocente.get().setContacto(docente.getContacto());
        existingDocente.get().setDomicilio(docente.getDomicilio());
        existingDocente.get().setFechaNacimiento(docente.getFechaNacimiento());
        return new ResponseEntity<>(docenteService.saveDocente(existingDocente.get()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteDocenteById(@PathVariable Integer id) {
        Optional<Docente> existingDocente = docenteService.getDocente(id);
        if (existingDocente.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        docenteService.deleteDocenteById(existingDocente.get().getId());
        return HttpStatus.NO_CONTENT;
    }
}

package com.german.edsystem.controllers;

import com.german.edsystem.models.Asignatura;
import com.german.edsystem.service.IAsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final IAsignaturaService asignaturaService;

    @GetMapping
    public ResponseEntity<Iterable<Asignatura>> getAsignaturas() {
        return new ResponseEntity<>(asignaturaService.getAsignaturas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Asignatura>> getAsignaturaById(@PathVariable Integer id) {
        Optional<Asignatura> asignatura = asignaturaService.getAsignatura(id);
        if (asignatura.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignatura, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
        return new ResponseEntity<>(asignaturaService.saveAsignatura(asignatura), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Asignatura> updateAsignatura(@RequestBody Asignatura asignatura) {
        Optional<Asignatura> existingAsignatura = asignaturaService.getAsignatura(asignatura.getIdAsignatura());
        if (existingAsignatura.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAsignatura.get().setNombre(asignatura.getNombre());
        return new ResponseEntity<>(asignaturaService.saveAsignatura(existingAsignatura.get()), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteAsignaturaById(@PathVariable Integer id) {
        asignaturaService.deleteAsignaturaById(id);
        return HttpStatus.NO_CONTENT;
    }
}

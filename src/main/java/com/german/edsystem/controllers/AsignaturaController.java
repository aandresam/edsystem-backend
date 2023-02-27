package com.german.edsystem.controllers;

import com.german.edsystem.models.Asignatura;
import com.german.edsystem.service.IAsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final IAsignaturaService asignaturaService;

    @GetMapping
    public ResponseEntity<List<Asignatura>> getAsignaturas() {
        return new ResponseEntity<>(asignaturaService.getAsignaturas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getAsignatura(@PathVariable Integer id) {
        Asignatura asignatura = asignaturaService.getAsignatura(id);
        if (asignatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignatura, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
        return new ResponseEntity<>(asignaturaService.saveAsignatura(asignatura), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Asignatura> updateAsignatura(@RequestBody Asignatura asignatura) {
        Asignatura existingAsignatura = asignaturaService.getAsignatura(asignatura.getIdAsignatura());
        if (existingAsignatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAsignatura.setNombre(asignatura.getNombre());
        return new ResponseEntity<>(asignaturaService.saveAsignatura(existingAsignatura), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteAsignatura(@PathVariable Integer id) {
        asignaturaService.deleteAsignaturaById(id);
        return HttpStatus.NO_CONTENT;
    }
}

package com.german.edsystem.controllers;

import com.german.edsystem.models.PeriodoAcademico;
import com.german.edsystem.service.IPeriodoAcademicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("periodos-academicos")
public class PeriodoAcademicoController {
    private final IPeriodoAcademicoService periodoAcademicoService;

    @GetMapping
    public ResponseEntity<Iterable<PeriodoAcademico>> getPeriodos() {
        return new ResponseEntity<>(this.periodoAcademicoService.getPeriodos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PeriodoAcademico>> getPeriodoById(@PathVariable("id") Integer id) {
        Optional<PeriodoAcademico> periodo = this.periodoAcademicoService.getPeriodoById(id);
        if (periodo.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(periodo, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<PeriodoAcademico> createPeriodo(@RequestBody PeriodoAcademico periodo) {
        return new ResponseEntity<>(this.periodoAcademicoService.savePeriodo(periodo), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<PeriodoAcademico> updatePeriodo(@RequestBody PeriodoAcademico periodo) {
        Optional<PeriodoAcademico> existingPeriodo = this.periodoAcademicoService
                .getPeriodoById(periodo.getId());
        if (existingPeriodo.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingPeriodo.get().setNombre(periodo.getNombre());
        existingPeriodo.get().setFechaInicio(periodo.getFechaInicio());
        existingPeriodo.get().setFechaFin(periodo.getFechaFin());
        return new ResponseEntity<>(this.periodoAcademicoService
                .savePeriodo(existingPeriodo.get()), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deletePeriodoById(@PathVariable("id") Integer id) {
        Optional<PeriodoAcademico> existingPeriodo = this.periodoAcademicoService.getPeriodoById(id);
        if (existingPeriodo.isEmpty()){
            return HttpStatus.NOT_FOUND;
        }
        this.periodoAcademicoService.deletePeriodoById(existingPeriodo.get().getId());
        return HttpStatus.NO_CONTENT;
    }
}

package com.german.edsystem.controllers;

import com.german.edsystem.models.Horario;
import com.german.edsystem.service.IHorarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("horarios")
public class HorarioController {

    private final IHorarioService horarioService;

    @GetMapping
    public ResponseEntity<Iterable<Horario>> getHorarios() {
        return new ResponseEntity<>(this.horarioService.getHorarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Horario>> getHorarioById(@PathVariable Integer id) {
        Optional<Horario> horario = this.horarioService.getHorario(id);
        if (horario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(horario, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Horario> createHorario(@RequestBody Horario horario) {
        return new ResponseEntity<>(this.horarioService.saveHorario(horario), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Horario> updateHorario(@RequestBody Horario horario) {
        Optional<Horario> existingHorario = this.horarioService.getHorario(horario.getIdHorario());
        if (existingHorario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingHorario.get().setDescripcion(horario.getDescripcion());
        return new ResponseEntity<>(this.horarioService.saveHorario(existingHorario.get()), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteHorarioById(@PathVariable Integer id) {
        Optional<Horario> existingHorario = this.horarioService.getHorario(id);
        if (existingHorario.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        this.horarioService.deleteHorarioById(existingHorario.get().getIdHorario());
        return HttpStatus.NO_CONTENT;
    }
}

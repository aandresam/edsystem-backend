package com.german.edsystem.controllers;

import com.german.edsystem.models.Horario;
import com.german.edsystem.service.IHorarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("horarios")
public class HorarioController {

    private final IHorarioService horarioService;

    @GetMapping
    public ResponseEntity<List<Horario>> getHorarios() {
        return new ResponseEntity<>(horarioService.getHorarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorario(@PathVariable Integer id) {
        Horario horario = horarioService.getHorario(id);
        if (horario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(horario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Horario> createHorario(@RequestBody Horario horario) {
        return new ResponseEntity<>(horarioService.saveHorario(horario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Horario> updateHorario(@RequestBody Horario horario) {
        Horario existingHorario = horarioService.getHorario(horario.getIdHorario());
        if (existingHorario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingHorario.setDescripcion(horario.getDescripcion());
        return new ResponseEntity<>(horarioService.saveHorario(existingHorario), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteHorario(@PathVariable Integer id) {
        horarioService.deleteHorarioById(id);
        return HttpStatus.NO_CONTENT;
    }
}

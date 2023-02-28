package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Docente;

import java.util.Optional;

public interface DocenteRepository {
    Optional<Docente> getDocenteById(Integer id);
    Iterable<Docente> getDocentes();
    Docente saveDocente(Docente docente);
    void deleteDocenteById(Integer id);
}

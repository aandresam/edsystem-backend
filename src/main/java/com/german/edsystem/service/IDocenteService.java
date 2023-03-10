package com.german.edsystem.service;

import com.german.edsystem.models.Docente;

import java.util.Optional;

public interface IDocenteService {

    Iterable<Docente> getDocentes();

    Optional<Docente> getDocente(Integer id);

    Docente createDocente(Docente docente);
    Docente updateDocente(Docente docente);

    void deleteDocenteById(Integer id);
}

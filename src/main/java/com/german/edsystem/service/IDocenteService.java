package com.german.edsystem.service;

import com.german.edsystem.models.Docente;

import java.util.Optional;

public interface IDocenteService {

    Iterable<Docente> getDocentes();

    Optional<Docente> getDocente(Integer id);

    Docente saveDocente(Docente docente);

    void deleteDocenteById(Integer id);
}

package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Docente;

import java.util.List;

public interface DocenteRepository {
    Docente getDocenteById(Integer id);
    List<Docente> getDocentes();
    Docente saveDocente(Docente docente);
    void deleteDocenteById(Integer id);
}

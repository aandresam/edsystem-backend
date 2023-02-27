package com.german.edsystem.service;

import com.german.edsystem.models.Docente;

import java.util.List;

public interface IDocenteService {

    public List<Docente> getDocentes();

    public Docente getDocente(Integer id);

    public Docente saveDocente(Docente docente);

    public void deleteDocenteById(Integer id);
}

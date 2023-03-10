package com.german.edsystem.service;

import com.german.edsystem.models.Horario;

import java.util.Optional;

public interface IHorarioService {
    Iterable<Horario> getHorarios();

    Optional<Horario> getHorario(Integer id);

    Horario createHorario(Horario horario);
    Horario updateHorario(Horario horario);

    void deleteHorarioById(Integer id);
}

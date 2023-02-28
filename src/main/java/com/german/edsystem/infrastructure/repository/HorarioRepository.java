package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Horario;

import java.util.Optional;

public interface HorarioRepository {
    Optional<Horario> getHorarioById(Integer id);
    Iterable<Horario> getHorarios();
    Horario saveHorario(Horario horario);
    void deleteHorarioById(Integer id);
}

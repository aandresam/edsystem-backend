package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Horario;

import java.util.List;

public interface HorarioRepository {
    Horario getHorarioById(Integer id);
    List<Horario> getHorarios();
    Horario saveHorario(Horario horario);
    void deleteHorarioById(Integer id);
}

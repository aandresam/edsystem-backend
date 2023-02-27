package com.german.edsystem.service;

import com.german.edsystem.models.Horario;

import java.util.List;

public interface IHorarioService {
    public List<Horario> getHorarios();

    public Horario getHorario(Integer id);

    public Horario saveHorario(Horario horario);

    public void deleteHorarioById(Integer id);
}

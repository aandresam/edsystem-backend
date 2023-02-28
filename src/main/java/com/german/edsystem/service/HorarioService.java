package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.HorarioRepository;
import com.german.edsystem.models.Horario;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class HorarioService implements IHorarioService {
    private final HorarioRepository horarioRepository;
    @Override
    public Iterable<Horario> getHorarios() {
        return this.horarioRepository.getHorarios();
    }

    @Override
    public Optional<Horario> getHorario(Integer id) {
        return this.horarioRepository.getHorarioById(id);
    }

    @Override
    public Horario saveHorario(Horario horario) {
        return this.horarioRepository.saveHorario(horario);
    }

    @Override
    public void deleteHorarioById(Integer id) {
        this.horarioRepository.deleteHorarioById(id);
    }
}

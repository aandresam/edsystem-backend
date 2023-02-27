package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.HorarioRepositoryJpa;
import com.german.edsystem.infrastructure.repository.HorarioRepository;
import com.german.edsystem.models.Horario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class HorarioRepositoryImpl implements HorarioRepository {
    private final HorarioRepositoryJpa horarioRepositoryJpa;

    @Override
    public Horario getHorarioById(Integer id) {
        return this.horarioRepositoryJpa.findById(id).orElse(null);
    }

    @Override
    public List<Horario> getHorarios() {
        return this.horarioRepositoryJpa.findAll();
    }

    @Override
    public Horario saveHorario(Horario horario) {
        return this.horarioRepositoryJpa.save(horario);
    }

    @Override
    public void deleteHorarioById(Integer id) {
        this.horarioRepositoryJpa.deleteById(id);
    }
}

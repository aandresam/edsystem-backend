package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.HorarioRepository;
import com.german.edsystem.models.Horario;
import com.german.edsystem.service.IHorarioService;
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
    public Horario createHorario(Horario horario) {
        return this.horarioRepository.saveHorario(horario);
    }
    @Override
    public Horario updateHorario(Horario horario) {
        Optional<Horario> existingHorario = this.horarioRepository.getHorarioById(horario.getIdHorario());
        if (existingHorario.isEmpty()) {
            return null;
        }
        existingHorario.get().setDescripcion(horario.getDescripcion());
        return this.horarioRepository.saveHorario(existingHorario.get());
    }

    @Override
    public void deleteHorarioById(Integer id) {
        this.horarioRepository.deleteHorarioById(id);
    }
}

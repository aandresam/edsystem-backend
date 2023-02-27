package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.RolRepositoryJpa;
import com.german.edsystem.infrastructure.repository.RolRepository;
import com.german.edsystem.models.Rol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RolRepositoryImpl implements RolRepository {
    private final RolRepositoryJpa rolRepositoryJpa;

    @Override
    public Rol getRolById(Integer id) {
        return this.rolRepositoryJpa.findById(id).orElse(null);
    }
}

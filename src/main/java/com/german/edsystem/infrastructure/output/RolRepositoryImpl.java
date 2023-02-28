package com.german.edsystem.infrastructure.output;

import com.german.edsystem.infrastructure.input.RolRepositoryJpa;
import com.german.edsystem.infrastructure.repository.RolRepository;
import com.german.edsystem.models.Rol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RolRepositoryImpl implements RolRepository {
    private final RolRepositoryJpa rolRepositoryJpa;

    @Override
    public Optional<Rol> getRolById(Integer id) {
        Rol rol = this.rolRepositoryJpa.findById(id).orElse(null);
        return Optional.ofNullable(rol);
    }

    @Override
    public Iterable<Rol> getRoles() {
        return this.rolRepositoryJpa.findAll();
    }

    @Override
    public Rol saveRol(Rol rol) {
        return this.rolRepositoryJpa.save(rol);
    }

    @Override
    public void deleteRolById(Integer id) {
        this.rolRepositoryJpa.deleteById(id);
    }
}

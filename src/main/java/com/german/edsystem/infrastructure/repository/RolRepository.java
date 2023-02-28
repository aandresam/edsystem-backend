package com.german.edsystem.infrastructure.repository;

import com.german.edsystem.models.Rol;
import java.util.Optional;

public interface RolRepository {
    Optional<Rol> getRolById(Integer id);
    Iterable<Rol> getRoles();
    Rol saveRol(Rol rol);
    void deleteRolById(Integer id);
}

package com.german.edsystem.service;

import com.german.edsystem.models.Rol;
import java.util.Optional;

public interface IRolService {
    Optional<Rol> getRolById(Integer id);
    Iterable<Rol> getRoles();
    Rol saveRol(Rol rol);
    void deleteRolById(Integer id);
}

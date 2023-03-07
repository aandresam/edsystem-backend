package com.german.edsystem.service.impls;

import com.german.edsystem.infrastructure.repository.RolRepository;
import com.german.edsystem.models.Rol;
import com.german.edsystem.service.IRolService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RolService implements IRolService {
    private final RolRepository rolRepository;
    @Override
    public Optional<Rol> getRolById(Integer id) {
        return this.rolRepository.getRolById(id);
    }

    @Override
    public Iterable<Rol> getRoles() {
        return this.rolRepository.getRoles();
    }

    @Override
    public Rol saveRol(Rol rol) {
        return this.rolRepository.saveRol(rol);
    }

    @Override
    public void deleteRolById(Integer id) {
        this.rolRepository.deleteRolById(id);
    }
}

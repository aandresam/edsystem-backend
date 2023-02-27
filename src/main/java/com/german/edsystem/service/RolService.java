package com.german.edsystem.service;

import com.german.edsystem.infrastructure.repository.RolRepository;
import com.german.edsystem.models.Rol;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RolService implements IRolService {
    private final RolRepository rolRepository;
    @Override
    public Rol getRolById(Integer id) {
        return this.rolRepository.getRolById(id);
    }
}

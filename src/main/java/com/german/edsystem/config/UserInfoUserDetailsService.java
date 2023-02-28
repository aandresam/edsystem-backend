package com.german.edsystem.config;

import com.german.edsystem.infrastructure.input.UsuarioRepositoryJpa;
import com.german.edsystem.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepositoryJpa usuarioRepositoryJpa;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepositoryJpa.findByUsername(username);
        return usuario.map(UsuarioUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}

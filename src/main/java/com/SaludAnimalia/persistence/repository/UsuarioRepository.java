package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByUsername(String username);
    boolean existsByCedula(String cedula);
    boolean existsByUsername(String username);
    boolean existsByTelefono(String telefono);
    boolean existsByEmail(String email);
}

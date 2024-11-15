package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer> {

    @Query(value = "SELECT p.permiso FROM roles_permisos rp JOIN permisos p ON rp.id_permiso = p.id WHERE rp.id_rol=:idRol", nativeQuery = true)
    List<String> findPermisosByIdRol(@Param("idRol") Integer id);
}

package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByUsername(String username);
    boolean existsByCedula(String cedula);
    boolean existsByUsername(String username);
    boolean existsByTelefono(String telefono);
    boolean existsByEmail(String email);

    @Query(value="SELECT u.* FROM usuarios u \n " +
            "JOIN mascotas m ON u.id=m.id_duenio\n " +
            "JOIN citas c ON c.id_mascota=m.id WHERE c.id= :idCita AND u.id_rol=1",nativeQuery = true)

    UsuarioEntity findUsuarioByIdCita(@Param("idCita") Integer idCita);

    @Query(value="SELECT u.* FROM usuarios u \n " +
            "JOIN mascotas m ON u.id=m.id_duenio\n AND m.id= :idMascota "
            ,nativeQuery = true)
    UsuarioEntity findUsuarioEntityByMascota(@Param("idMascota") Integer idMascota);
}

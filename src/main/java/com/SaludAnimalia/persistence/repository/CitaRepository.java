package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<CitaEntity, Integer> {

    List<CitaEntity> findCitaEntitiesByMascota_Duenio_Id(Integer idDuenio);
    List<CitaEntity> findCitaEntitiesByTurno_Veterinario_Id(Integer idVeterinario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE citas SET id_estado= :idEstado WHERE id= :idCita",nativeQuery = true)
    void actualizarEstadoCita(@Param("idCita") Integer idCita, @Param("idEstado") Integer idEstado);
}

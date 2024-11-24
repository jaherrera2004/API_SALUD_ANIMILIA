package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<TurnoEntity, Integer> {

    @Query(value = "SELECT * FROM turnos " +
            "WHERE disponible = true " +
            "AND DATE(fecha_inicio) = :fecha",
            nativeQuery = true)
    List<TurnoEntity> traerTurnosDisponiblesPorDia(@Param("fecha") LocalDate fecha);


    @Modifying
    @Transactional
    @Query(value = "UPDATE turnos SET disponible = :estado WHERE id = :id", nativeQuery = true)
    void actualizarTurno(@Param("id") Integer id, @Param("estado") Integer estado);


}

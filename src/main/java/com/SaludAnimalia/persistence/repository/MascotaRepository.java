package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.MascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<MascotaEntity, Integer> {
    List<MascotaEntity> findMascotaEntitiesByDuenio_Id(Integer idUsuario);

}

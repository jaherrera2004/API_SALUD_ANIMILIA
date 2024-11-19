package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.CitaEstadoEntity;
import com.SaludAnimalia.web.dto.CitaEstadoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaEstadoRepsitory extends JpaRepository<CitaEstadoEntity, Integer> {
}

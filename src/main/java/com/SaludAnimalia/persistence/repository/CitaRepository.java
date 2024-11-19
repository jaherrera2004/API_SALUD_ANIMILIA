package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<CitaEntity, Integer> {
}

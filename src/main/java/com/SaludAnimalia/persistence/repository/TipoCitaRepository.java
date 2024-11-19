package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.TipoCitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCitaRepository extends JpaRepository<TipoCitaEntity, Integer> {
}

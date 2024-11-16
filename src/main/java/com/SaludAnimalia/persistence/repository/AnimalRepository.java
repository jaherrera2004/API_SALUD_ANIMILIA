package com.SaludAnimalia.persistence.repository;

import com.SaludAnimalia.persistence.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {
}

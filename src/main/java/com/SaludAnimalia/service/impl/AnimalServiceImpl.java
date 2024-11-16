package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.entity.AnimalEntity;
import com.SaludAnimalia.persistence.repository.AnimalRepository;
import com.SaludAnimalia.service.interfaces.AnimalIService;
import com.SaludAnimalia.util.mapper.AnimalMapper;
import com.SaludAnimalia.web.dto.AnimalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalIService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalDto obtenerAnimalPorId(Integer id) {
        AnimalEntity animalEntity= animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Animal no existente"));
        return animalMapper.toDto(animalEntity);
    }
}

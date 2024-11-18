package com.SaludAnimalia.service.interfaces;

import com.SaludAnimalia.web.dto.AnimalDto;

import java.util.List;

public interface AnimalIService {
    AnimalDto obtenerAnimalPorId(Integer id);

    List<AnimalDto> obtenerAnimales();
}

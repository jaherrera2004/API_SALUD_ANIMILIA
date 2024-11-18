package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.AnimalIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.AnimalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH + "/animales")
public class AnimalController {

    private final AnimalIService animalIService;

    @PreAuthorize("hasAuthority('animal:obtener-lista')")
    @GetMapping
    public List<AnimalDto> obtenerAnimales() {
        return animalIService.obtenerAnimales();
    }
}

package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.TurnoIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.TurnoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH + "/turnos")
public class TurnosController {

    private final TurnoIService turnoIService;

    @PreAuthorize("hasAuthority('turno:obtener-por-dia')")
    @GetMapping
    public List<TurnoDto> obtenerTurnosPorDia(@RequestParam LocalDate fecha) {
        return turnoIService.obtenerTurnosPorDia(fecha);
    }

    @GetMapping("/{idVeterinario}")
    @PreAuthorize("hasAuthority('turno:obtener-veterinario')")
    public List<TurnoDto> obtenerTurnoPorVeterinario(Integer idVeterinario){
        return null;
    }
}

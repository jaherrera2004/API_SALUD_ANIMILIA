package com.SaludAnimalia.service.interfaces;

import com.SaludAnimalia.web.dto.TurnoDto;

import java.time.LocalDate;
import java.util.List;

public interface TurnoIService {
    List<TurnoDto> obtenerTurnosPorDia(LocalDate fecha);
    TurnoDto obtenerTurnoPorId(Integer id);
    void actualizarTurno(Integer id, Integer estado);
}

package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.entity.TurnoEntity;
import com.SaludAnimalia.persistence.repository.TurnoRepository;
import com.SaludAnimalia.service.interfaces.TurnoIService;
import com.SaludAnimalia.util.mapper.TurnoMapper;
import com.SaludAnimalia.web.dto.TurnoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnoServiceImpl implements TurnoIService {

    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;

    @Override
    public List<TurnoDto> obtenerTurnosPorDia(LocalDate fecha) {
        return turnoRepository.traerTurnosDisponiblesPorDia(fecha)
                .stream()
                .map(turnoMapper::toDto)
                .toList();
    }

    @Override
    public TurnoDto obtenerTurnoPorId(Integer id) {

        TurnoEntity turnoEntity = turnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turno no existente"));

        return turnoMapper.toDto(turnoEntity);
    }

    @Override
    public void actualizarTurno(Integer id, Integer  estado) {
        turnoRepository.actualizarTurno(id,estado);
    }
}

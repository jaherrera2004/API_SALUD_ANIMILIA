package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.entity.CitaEstadoEntity;
import com.SaludAnimalia.persistence.repository.CitaEstadoRepsitory;
import com.SaludAnimalia.service.interfaces.CitaEstadoIService;
import com.SaludAnimalia.util.mapper.CitaEstadoMapper;
import com.SaludAnimalia.web.dto.CitaEstadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CitaEstadoImpl implements CitaEstadoIService {

    private final CitaEstadoRepsitory citaEstadoRepsitory;
    private final CitaEstadoMapper citaEstadoMapper;

    @Override
    public CitaEstadoDto obtenerPorId(Integer id) {

        CitaEstadoEntity citaEstadoEntity= citaEstadoRepsitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no existente"));

        return citaEstadoMapper.toDto(citaEstadoEntity);
    }
}

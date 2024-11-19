package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.entity.TipoCitaEntity;
import com.SaludAnimalia.persistence.repository.TipoCitaRepository;
import com.SaludAnimalia.service.interfaces.TipoCitaIService;
import com.SaludAnimalia.util.mapper.TipoCitaMapper;

import com.SaludAnimalia.web.dto.TipoCitaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoCitaServiceImpl implements TipoCitaIService {

    private final TipoCitaRepository tipoCitaRepository;
    private final TipoCitaMapper tipoCitaMapper;

    @Override
    public List<TipoCitaDto> obtenerTiposCita() {

        return tipoCitaRepository.findAll()
                .stream()
                .map(tipoCitaMapper::toDto)
                .toList();
    }

    @Override
    public TipoCitaDto obtenerTipoCitaPorId(Integer id) {

        TipoCitaEntity tipoCitaEntity = tipoCitaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo cita inexistente"));

        return tipoCitaMapper.toDto(tipoCitaEntity);
    }
}

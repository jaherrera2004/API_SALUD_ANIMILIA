package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.repository.CitaRepository;
import com.SaludAnimalia.service.interfaces.*;
import com.SaludAnimalia.util.mapper.CitaMapper;
import com.SaludAnimalia.web.dto.*;
import com.SaludAnimalia.web.dto.request.CitaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaIService {

    private final CitaRepository citaRepository;
    private final MascotaIService mascotaIService;
    private final TurnoIService turnoIService;
    private final TipoCitaIService tipoCitaIService;
    private final CitaEstadoIService citaEstadoIService;
    private final CitaMapper citaMapper;

    @Override
    public void agendarCita(CitaRequest request) {

        MascotaDto mascotaDto = mascotaIService.obtenerMascotaPorId(request.getIdMascota());
        TurnoDto turnoDto = turnoIService.obtenerTurnoPorId(request.getIdTurno());
        TipoCitaDto tipoCitaDto = tipoCitaIService.obtenerTipoCitaPorId(request.getIdTipo());
        CitaEstadoDto citaEstadoDto = citaEstadoIService.obtenerPorId(1);

        CitaDto citaDto = new CitaDto();
        citaDto.setTipoCita(tipoCitaDto);
        citaDto.setTurno(turnoDto);
        citaDto.setObservaciones(request.getObservaciones());
        citaDto.setMascota(mascotaDto);
        citaDto.setEstado(citaEstadoDto);

        citaRepository.save(citaMapper.toEntity(citaDto));
        turnoIService.actualizarTurno(request.getIdTurno(),0);
    }


}
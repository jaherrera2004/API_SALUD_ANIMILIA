package com.SaludAnimalia.service.interfaces;

import com.SaludAnimalia.web.dto.CitaDto;
import com.SaludAnimalia.web.dto.request.CitaRequest;

import java.util.List;

public interface CitaIService {
    void agendarCita(CitaRequest request);

    List<CitaDto> obtenerCitasPorUsuario(Integer idUsuario);

    void actualizarEstadoCita(Integer idCita, Integer idEstado);
}

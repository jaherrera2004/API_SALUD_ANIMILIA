package com.SaludAnimalia.service.interfaces;

import com.SaludAnimalia.web.dto.MascotaDto;
import com.SaludAnimalia.web.dto.request.MascotaRequest;

import java.util.List;

public interface MascotaIService {

    void registrarMascota(MascotaRequest request);
    List<MascotaDto> obtenerMascotasPorUsuario(Integer idUsuario);
}

package com.SaludAnimalia.service.interfaces;

import com.SaludAnimalia.web.dto.TipoCitaDto;

import java.util.List;

public interface TipoCitaIService {
    List<TipoCitaDto> obtenerTiposCita();
    TipoCitaDto obtenerTipoCitaPorId(Integer id);
}

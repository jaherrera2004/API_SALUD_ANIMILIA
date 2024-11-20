package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.TipoCitaIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.TipoCitaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH+"/tipo-citas")
public class TipoCitaController {

    private final TipoCitaIService tipoCitaIService;

    @GetMapping
    @PreAuthorize("hasAuthority('tipo-citas:obtener-lista')")
    public List<TipoCitaDto> obtenerTiposCitas(){
        return tipoCitaIService.obtenerTiposCita();
    }

}

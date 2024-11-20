package com.SaludAnimalia.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CitaRequest {

    @NotNull
    private Integer idMascota;

    @NotNull
    private Integer idTurno;

    @NotNull
    private Integer idTipo;

    private String observaciones;

}

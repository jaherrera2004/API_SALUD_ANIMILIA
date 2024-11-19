package com.SaludAnimalia.web.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CitaRequest {

    @NotNull
    @NotEmpty
    private Integer idMascota;

    @NotNull
    @NotEmpty
    private Integer idTurno;

    @NotNull
    @NotEmpty
    private Integer idTipo;

    private String observaciones;

}

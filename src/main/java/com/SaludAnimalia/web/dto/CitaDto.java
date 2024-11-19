package com.SaludAnimalia.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CitaDto {
    private Integer id;
    private String observaciones;
    private CitaEstadoDto estado;
    private TurnoDto turno;
    private MascotaDto mascota;
    private TipoCitaDto tipoCita;
}

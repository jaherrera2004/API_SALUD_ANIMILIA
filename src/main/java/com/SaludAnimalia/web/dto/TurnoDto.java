package com.SaludAnimalia.web.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class TurnoDto {

    private Integer id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean disponible;
    private UsuarioDto veterinario;

}

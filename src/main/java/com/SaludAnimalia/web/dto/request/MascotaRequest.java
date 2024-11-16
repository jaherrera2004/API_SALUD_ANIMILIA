package com.SaludAnimalia.web.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MascotaRequest {

    @NotNull
    @NotEmpty
    private String nombre;

    @NotNull
    @NotEmpty
    private String raza;

    @NotNull
    private Integer edad;

    @NotNull
    private char sexo;

    @NotNull
    @Positive
    private Integer idAnimal;

    @NotNull
    @Positive
    private Integer idDuenio;

}

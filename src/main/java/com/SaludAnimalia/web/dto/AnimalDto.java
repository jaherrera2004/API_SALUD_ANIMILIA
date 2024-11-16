package com.SaludAnimalia.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnimalDto {
    private Integer id;
    private String animal;
    private String descripcion;
}


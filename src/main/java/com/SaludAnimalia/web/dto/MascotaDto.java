package com.SaludAnimalia.web.dto;


import lombok.Data;


@Data
public class MascotaDto {

    private Integer id;
    private String raza;
    private Integer edad;
    private String nombre;
    private char sexo;
    private UsuarioDto duenio;
    private AnimalDto animal;

}

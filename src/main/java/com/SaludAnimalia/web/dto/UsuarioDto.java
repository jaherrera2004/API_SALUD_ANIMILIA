package com.SaludAnimalia.web.dto;

import lombok.*;

@Data
public class UsuarioDto {

    private Integer id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String telefono;
    private String email;
    private String username;
    private String contrasenia;
    private RolDto rol;
}

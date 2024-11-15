package com.SaludAnimalia.web.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

    @NotNull
    @NotEmpty
    private String cedula;

    @NotNull
    @NotEmpty
    private String nombre;

    @NotNull
    @NotEmpty
    private String apellido;

    @NotNull
    @Min(18)
    private Integer edad;

    @NotNull
    @NotEmpty
    private String telefono;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String contrasenia;

    @NotNull
    @Positive
    private Integer idRol;
}

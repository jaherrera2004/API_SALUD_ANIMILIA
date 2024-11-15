package com.SaludAnimalia.web.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    @NotEmpty(message = "El nombre de usuario no puede estar vacío.")
    @NotNull(message = "El nombre de usuario es obligatorio.")
    private String username;

    @NotEmpty(message = "La contraseña no puede estar vacía.")
    @NotNull(message = "La contraseña es obligatoria.")
    private String contrasenia;
}

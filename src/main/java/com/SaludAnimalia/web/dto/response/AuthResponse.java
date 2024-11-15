package com.SaludAnimalia.web.dto.response;

import com.SaludAnimalia.web.dto.response.usuario.UsuarioDatosResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponse {
    private String accessToken;
    private UsuarioDatosResponse usuarioDatosResponse;
}

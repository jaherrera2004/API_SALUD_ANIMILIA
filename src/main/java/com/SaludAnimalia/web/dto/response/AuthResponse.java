package com.SaludAnimalia.web.dto.response;

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

package com.SaludAnimalia.service.strategy;

import com.SaludAnimalia.web.dto.UsuarioDto;

public interface EnviarEmail{
    void enviarCorreo(UsuarioDto usuarioDto);
    String construirMensaje(UsuarioDto usuarioDto);
}

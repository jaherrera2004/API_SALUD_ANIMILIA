package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.service.strategy.EnviarEmail;
import com.SaludAnimalia.service.strategy.TIPOS_CORREOS;
import com.SaludAnimalia.service.strategy.impls.EmailAgenda;
import com.SaludAnimalia.service.strategy.impls.EmailCancelacion;
import com.SaludAnimalia.service.strategy.impls.EmailRegistro;
import com.SaludAnimalia.web.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class EmailSenderService {

    private final Map<TIPOS_CORREOS, EnviarEmail> emailStrategies;

    public void sendEmail(UsuarioDto usuarioDto, TIPOS_CORREOS tipoCorreo) {
        EnviarEmail enviarEmail = emailStrategies.get(tipoCorreo);
        if (enviarEmail == null) {
            throw new IllegalStateException("Tipo de correo no soportado: " + tipoCorreo);
        }
        enviarEmail.enviarCorreo(usuarioDto);
    }
}

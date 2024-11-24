package com.SaludAnimalia.service.strategy;

import com.SaludAnimalia.service.strategy.impls.EmailAgenda;
import com.SaludAnimalia.service.strategy.impls.EmailCancelacion;
import com.SaludAnimalia.service.strategy.impls.EmailRegistro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class EmailStrategyConfig {

    @Bean
    public Map<TIPOS_CORREOS, EnviarEmail> emailStrategies(
            EmailRegistro emailRegistro,
            EmailAgenda emailAgenda,
            EmailCancelacion emailCancelacion) {
        return Map.of(
                TIPOS_CORREOS.REGISTRO, emailRegistro,
                TIPOS_CORREOS.AGENDA, emailAgenda,
                TIPOS_CORREOS.CANCELACION, emailCancelacion
        );
    }
}

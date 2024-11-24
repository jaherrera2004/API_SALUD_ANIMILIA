package com.SaludAnimalia.service.strategy.impls;

import com.SaludAnimalia.service.strategy.EnviarEmail;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class EmailAgenda implements EnviarEmail {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void enviarCorreo(UsuarioDto usuarioDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(DatosGenerales.EMAIL);
        simpleMailMessage.setTo(usuarioDto.getEmail());
        simpleMailMessage.setSubject("Nueva cita agendada.");
        simpleMailMessage.setText(construirMensaje(usuarioDto));

        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public String construirMensaje(UsuarioDto usuarioDto) {
        return "Hola " + usuarioDto.getNombre() + " " + usuarioDto.getApellido() + ", Tu cita ha sido agendada correctamente. Ingresa a la plataforma para ver los detalles.";
    }

}

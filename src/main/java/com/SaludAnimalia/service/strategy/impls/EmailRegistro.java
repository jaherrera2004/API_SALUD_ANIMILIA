package com.SaludAnimalia.service.strategy.impls;


import com.SaludAnimalia.service.strategy.EnviarEmail;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailRegistro implements EnviarEmail {

    @Autowired
    JavaMailSender javaMailSender;


    @Override
    public void enviarCorreo(UsuarioDto usuarioDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(DatosGenerales.EMAIL);
        simpleMailMessage.setTo(usuarioDto.getEmail());
        simpleMailMessage.setSubject("Registro en Salud Animalia");
        simpleMailMessage.setText(construirMensaje(usuarioDto));

        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public String construirMensaje(UsuarioDto usuarioDto) {
        return "Hola " + usuarioDto.getNombre() + " " + usuarioDto.getApellido() + " gracias por registrarte en Salud Animalia";
    }

}

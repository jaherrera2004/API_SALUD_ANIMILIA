package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.repository.RolRepository;
import com.SaludAnimalia.persistence.repository.UsuarioRepository;
import com.SaludAnimalia.service.JwtService;
import com.SaludAnimalia.service.interfaces.AuthIService;
import com.SaludAnimalia.service.interfaces.UsuarioIService;
import com.SaludAnimalia.util.mapper.UsuarioMapper;
import com.SaludAnimalia.web.advice.exception.HttpGenericException;
import com.SaludAnimalia.web.dto.CustomUserDetails;
import com.SaludAnimalia.web.dto.UsuarioDto;
import com.SaludAnimalia.web.dto.request.AuthRequest;
import com.SaludAnimalia.web.dto.response.AuthResponse;
import com.SaludAnimalia.web.dto.response.usuario.UsuarioDatosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthIService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioIService usuarioIService;
    private final RolRepository rolRepository;
    private final JwtService jwtService;

    @Override
    public AuthResponse iniciarSesion(AuthRequest request) {
        UsuarioDto datosUsuario =usuarioIService.obtenerUsuarioPorUsername(request.getUsername());
        System.out.println(datosUsuario.getNombre());

        if (datosUsuario == null || !passwordEncoder.matches(request.getContrasenia(), datosUsuario.getContrasenia())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Username o contraseña incorrectos :(");
        }


        List<String> permisos = rolRepository.findPermisosByIdRol(datosUsuario.getRol().getId());
        List<SimpleGrantedAuthority> authorities = permisos
                .stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities);
        String rol= datosUsuario.getRol().getRol();
        CustomUserDetails customUserDetails = new CustomUserDetails(datosUsuario.getId(), request.getUsername(), "", rol, grantedAuthorities);

        String token = jwtService.generateToken(customUserDetails, permisos, datosUsuario.getId(), rol);
        return construirAuthResponse(token, datosUsuario);
    }

    private AuthResponse construirAuthResponse(String token, UsuarioDto datosUsuario){
        return AuthResponse.builder()
                .accessToken(token)
                .usuarioDatosResponse(UsuarioDatosResponse.builder()
                        .id(datosUsuario.getId())
                        .cedula(datosUsuario.getCedula())
                        .nombre(datosUsuario.getNombre())
                        .apellido(datosUsuario.getApellido())
                        .email(datosUsuario.getEmail())
                        .telefono(datosUsuario.getTelefono())
                        .edad(datosUsuario.getEdad())
                        .username(datosUsuario.getUsername())
                        .rol(datosUsuario.getRol().getRol())
                        .build())
                .build();
    }
}

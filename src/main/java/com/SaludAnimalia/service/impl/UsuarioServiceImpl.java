package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.entity.UsuarioEntity;
import com.SaludAnimalia.persistence.repository.UsuarioRepository;
import com.SaludAnimalia.service.interfaces.AuthIService;
import com.SaludAnimalia.service.interfaces.RolIService;
import com.SaludAnimalia.service.interfaces.UsuarioIService;
import com.SaludAnimalia.util.mapper.UsuarioMapper;
import com.SaludAnimalia.web.advice.exception.HttpGenericException;
import com.SaludAnimalia.web.dto.UsuarioDto;
import com.SaludAnimalia.web.dto.request.UsuarioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioIService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final RolIService rolIService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registrarUsuario(UsuarioRequest request) {

        if (usuarioRepository.existsByCedula(request.getCedula())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Ya existe un usuario registrado con esta cedula :(");
        }

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Ya existe un usuario registrado con este correo electronico :(");
        }

        if (usuarioRepository.existsByTelefono(request.getTelefono())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Ya existe un usuario registrado con este telefono:(");
        }

        if (usuarioRepository.existsByUsername(request.getUsername())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Ya existe un usuario registrado con este username :(");
        }

        UsuarioDto usuarioDto = usuarioMapper.toDto(request);
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));
        usuarioDto.setRol(rolIService.obtenerRolPorId(request.getIdRol()));

        usuarioRepository.save(usuarioMapper.toEntity(usuarioDto));
    }

    @Override
    public UsuarioDto obtenerUsuarioPorUsername(String username) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalArgumentException("Usuario no existente"));

        return usuarioMapper.toDto(usuarioEntity);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(Integer id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Usuario no existente"));

        return usuarioMapper.toDto(usuarioEntity);
    }
}

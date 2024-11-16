package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.RolIService;
import com.SaludAnimalia.service.interfaces.UsuarioIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.request.UsuarioRequest;
import com.SaludAnimalia.web.dto.response.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(DatosGenerales.BASE_PATH+"/usuarios")
public class UsuarioController {

    private final UsuarioIService usuarioIService;
    private final RolIService rolIService;

    @PostMapping
    public GenericResponse registrarUsuario(@RequestBody @Valid UsuarioRequest request){
        usuarioIService.registrarUsuario(request);
        return GenericResponse.ok(true, "Te has registrado exitosamente!");
    }

}

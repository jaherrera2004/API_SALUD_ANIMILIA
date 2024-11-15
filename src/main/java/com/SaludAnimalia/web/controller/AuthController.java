package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.AuthIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.request.AuthRequest;
import com.SaludAnimalia.web.dto.response.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(DatosGenerales.BASE_PATH+"/auth")
public class AuthController {

    private final AuthIService authIService;

    @PostMapping
    public AuthResponse iniciarSesion(@RequestBody @Valid AuthRequest request){
        return authIService.iniciarSesion(request);
    }
}

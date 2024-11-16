package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.request.MascotaRequest;
import com.SaludAnimalia.web.dto.response.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(DatosGenerales.BASE_PATH+"/mascotas")
public class MascotaController {

    public GenericResponse registrarMascota(@RequestBody @Valid MascotaRequest request){

        return GenericResponse.ok(true, request.getNombre()+" ha sido agregado a tu lista de mascotas!");
    }
}

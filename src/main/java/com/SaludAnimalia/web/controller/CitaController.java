package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.CitaIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.request.CitaRequest;
import com.SaludAnimalia.web.dto.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH + "/citas")
public class CitaController {

    private final CitaIService citaIIService;

    @PostMapping
    @PreAuthorize("hasAuthority('cita:agendar')")
    public GenericResponse agendarCita(@RequestBody CitaRequest request){
        System.out.println(request);
        citaIIService.agendarCita(request);

        return GenericResponse.ok(true, "Tu cita ha sido agendada exitosamente");
    }

}

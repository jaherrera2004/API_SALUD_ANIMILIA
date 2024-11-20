package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.CitaIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.CitaDto;
import com.SaludAnimalia.web.dto.request.CitaRequest;
import com.SaludAnimalia.web.dto.response.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH + "/citas")
public class CitaController {

    private final CitaIService citaIIService;

    @PostMapping
    @PreAuthorize("hasAuthority('cita:agendar')")
    public GenericResponse agendarCita(@RequestBody @Valid CitaRequest request) {
        System.out.println(request);
        citaIIService.agendarCita(request);

        return GenericResponse.ok(true, "Tu cita ha sido agendada exitosamente");
    }

    @GetMapping("/usuario/{idUsuario}")
    @PreAuthorize("hasAuthority('cita:obtener-citas-usuario')")
    public List<CitaDto> obtenerCitasPorUsuario(@PathVariable Integer idUsuario) {
        return citaIIService.obtenerCitasPorUsuario(idUsuario);
    }

    @PutMapping("/{idCita}/{idEstado}")
    @PreAuthorize("hasAuthority('cita:actualizar-estado')")
    public GenericResponse actualizarEstadoCita(@PathVariable Integer idCita, @PathVariable Integer idEstado) {
        citaIIService.actualizarEstadoCita(idCita, idEstado);
        return GenericResponse.ok(true, "El estado de su cita ha sido actualizado!");
    }

}

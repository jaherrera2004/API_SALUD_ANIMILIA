package com.SaludAnimalia.web.controller;

import com.SaludAnimalia.service.interfaces.MascotaIService;
import com.SaludAnimalia.util.DatosGenerales;
import com.SaludAnimalia.web.dto.MascotaDto;
import com.SaludAnimalia.web.dto.request.MascotaRequest;
import com.SaludAnimalia.web.dto.response.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(DatosGenerales.BASE_PATH + "/mascotas")
public class MascotaController {

    private final MascotaIService mascotaIService;

    @PreAuthorize("hasAuthority('mascota:registrar-mascota')")
    @PostMapping
    public GenericResponse registrarMascota(@RequestBody @Valid MascotaRequest request) {
        mascotaIService.registrarMascota(request);
        return GenericResponse.ok(true, request.getNombre() + " ha sido agregado a tu lista de mascotas!");
    }

    @PreAuthorize("hasAuthority('mascota:obtener-lista-usuario')")
    @GetMapping("/usuario/{idUsuario}")
    public List<MascotaDto> obtenerMascotasPorUsuario(@PathVariable Integer idUsuario) {
        return mascotaIService.obtenerMascotasPorUsuario(idUsuario);
    }

    @PreAuthorize("hasAuthority('mascota:eliminar')")
    @DeleteMapping("/{id}")
    public GenericResponse eliminarMascota(@PathVariable Integer id) {
        mascotaIService.eliminarMascota(id);
        return GenericResponse.ok(true, "Has eliminado a tu mascota");
    }
}

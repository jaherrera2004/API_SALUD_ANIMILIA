package com.SaludAnimalia.service.interfaces;

import com.SaludAnimalia.web.dto.UsuarioDto;
import com.SaludAnimalia.web.dto.request.UsuarioRequest;

public interface UsuarioIService {

    void registrarUsuario(UsuarioRequest request);

    UsuarioDto obtenerUsuarioPorUsername(String username);

    UsuarioDto obtenerUsuarioPorId(Integer id);
}

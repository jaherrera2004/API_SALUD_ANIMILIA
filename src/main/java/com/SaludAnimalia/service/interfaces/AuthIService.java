package com.SaludAnimalia.service.interfaces;

import com.SaludAnimalia.web.dto.request.AuthRequest;
import com.SaludAnimalia.web.dto.response.AuthResponse;

public interface AuthIService {
    AuthResponse iniciarSesion(AuthRequest request);
}

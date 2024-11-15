package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.entity.RolEntity;
import com.SaludAnimalia.persistence.repository.RolRepository;
import com.SaludAnimalia.service.interfaces.RolIService;
import com.SaludAnimalia.util.mapper.RolMapper;
import com.SaludAnimalia.web.dto.RolDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RolServiceImpl implements RolIService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public RolDto obtenerRolPorId(Integer id) {
        RolEntity rolEntity = rolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El rol con ID " + id + " no existe"));
        return rolMapper.toDto(rolEntity);
    }
}

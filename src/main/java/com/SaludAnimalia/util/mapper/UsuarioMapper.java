package com.SaludAnimalia.util.mapper;

import com.SaludAnimalia.persistence.entity.UsuarioEntity;
import com.SaludAnimalia.web.dto.UsuarioDto;
import com.SaludAnimalia.web.dto.request.UsuarioRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
        UsuarioEntity toEntity (UsuarioDto request);
        UsuarioDto toDto(UsuarioEntity entity);
        UsuarioDto toDto(UsuarioRequest request);
}

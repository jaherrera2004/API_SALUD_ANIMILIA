package com.SaludAnimalia.util.mapper;

import com.SaludAnimalia.persistence.entity.RolEntity;
import com.SaludAnimalia.web.dto.RolDto;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDto toDto(RolEntity entity);
    RolEntity toEntity(RolDto dto);
}

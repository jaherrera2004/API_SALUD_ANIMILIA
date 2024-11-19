package com.SaludAnimalia.util.mapper;

import com.SaludAnimalia.persistence.entity.CitaEntity;
import com.SaludAnimalia.web.dto.CitaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    CitaDto toDto(CitaEntity entity);

    CitaEntity toEntity(CitaDto dto);
}

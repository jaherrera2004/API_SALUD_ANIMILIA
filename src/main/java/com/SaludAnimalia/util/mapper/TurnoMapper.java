package com.SaludAnimalia.util.mapper;

import com.SaludAnimalia.persistence.entity.TurnoEntity;
import com.SaludAnimalia.web.dto.TurnoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TurnoMapper {
    TurnoDto toDto(TurnoEntity entity);

    TurnoEntity toEntity(TurnoDto turnoDto);
}

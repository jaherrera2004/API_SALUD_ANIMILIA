package com.SaludAnimalia.util.mapper;
import com.SaludAnimalia.persistence.entity.CitaEstadoEntity;
import com.SaludAnimalia.web.dto.CitaEstadoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CitaEstadoMapper {

    CitaEstadoDto toDto(CitaEstadoEntity entity);
    CitaEstadoEntity toEntity(CitaEstadoDto dto);
}

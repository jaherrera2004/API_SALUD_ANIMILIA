package com.SaludAnimalia.util.mapper;

import com.SaludAnimalia.persistence.entity.MascotaEntity;
import com.SaludAnimalia.web.dto.MascotaDto;
import com.SaludAnimalia.web.dto.request.MascotaRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MascotaMapper {
    MascotaDto toDto(MascotaRequest request);

    MascotaDto toDto(MascotaEntity entity);

    MascotaEntity toEntity(MascotaDto dto);
}

package com.SaludAnimalia.util.mapper;

import com.SaludAnimalia.persistence.entity.TipoCitaEntity;
import com.SaludAnimalia.web.dto.TipoCitaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoCitaMapper {

    TipoCitaDto toDto(TipoCitaEntity entity);

    TipoCitaEntity toEntity(TipoCitaDto dto);
}

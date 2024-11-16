package com.SaludAnimalia.util.mapper;

import com.SaludAnimalia.persistence.entity.AnimalEntity;
import com.SaludAnimalia.web.dto.AnimalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    AnimalDto toDto(AnimalEntity entity);

    AnimalEntity toEntity(AnimalDto dto);

}

package com.SaludAnimalia.service.impl;

import com.SaludAnimalia.persistence.entity.MascotaEntity;
import com.SaludAnimalia.persistence.repository.AnimalRepository;
import com.SaludAnimalia.persistence.repository.MascotaRepository;
import com.SaludAnimalia.persistence.repository.UsuarioRepository;
import com.SaludAnimalia.service.interfaces.AnimalIService;
import com.SaludAnimalia.service.interfaces.MascotaIService;
import com.SaludAnimalia.service.interfaces.UsuarioIService;
import com.SaludAnimalia.util.mapper.MascotaMapper;
import com.SaludAnimalia.util.mapper.UsuarioMapper;
import com.SaludAnimalia.web.advice.exception.HttpGenericException;
import com.SaludAnimalia.web.dto.AnimalDto;
import com.SaludAnimalia.web.dto.MascotaDto;
import com.SaludAnimalia.web.dto.UsuarioDto;
import com.SaludAnimalia.web.dto.request.MascotaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaIService {

    private final MascotaRepository mascotaRepository;
    private final MascotaMapper mascotaMapper;
    private final AnimalRepository animalRepository;
    private final AnimalIService animalIService;
    private final UsuarioIService usuarioIService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public void registrarMascota(MascotaRequest request) {

        if (!animalRepository.existsById(request.getIdAnimal())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Lo sentimos! El animal que has ingresado no lo tenemos registrad :(");
        }

        if (!usuarioRepository.existsById(request.getIdDuenio())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Lo sentimos!, No pudimos encontrar el dueño.");
        }

        AnimalDto animalDto = animalIService.obtenerAnimalPorId(request.getIdAnimal());
        UsuarioDto usuarioDto = usuarioIService.obtenerUsuarioPorId(request.getIdDuenio());

        MascotaDto mascotaDto = mascotaMapper.toDto(request);

        mascotaDto.setAnimal(animalDto);
        mascotaDto.setDuenio(usuarioDto);
        MascotaEntity entity = mascotaMapper.toEntity(mascotaDto);

        mascotaRepository.save(entity);
    }

    @Override
    public List<MascotaDto> obtenerMascotasPorUsuario(Integer idUsuario) {

        if(!usuarioRepository.existsById(idUsuario)){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST,"El usuario que has ingresado no existe");
        }

        return mascotaRepository.findMascotaEntitiesByDuenio_Id(idUsuario)
                .stream()
                .map(mascotaMapper::toDto)
                .toList();
    }
}

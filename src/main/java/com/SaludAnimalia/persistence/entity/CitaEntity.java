package com.SaludAnimalia.persistence.entity;

import com.SaludAnimalia.web.dto.CitaEstadoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "citas")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String observaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_cita")
    private TipoCitaEntity tipoCita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado")
    private CitaEstadoEntity estado;

    @OneToOne
    @JoinColumn(name = "id_turno")
    private TurnoEntity turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mascota")
    private MascotaEntity mascota;


}

package com.SaludAnimalia.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estados_cita")
public class CitaEstadoEntity {

    @Id
    private Integer id;
    private String estado;
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "estado")
    private List<CitaEntity> citas;
}

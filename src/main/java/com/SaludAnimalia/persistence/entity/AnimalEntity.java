package com.SaludAnimalia.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "animales")
public class AnimalEntity {

    @Id
    private Integer id;
    private String animal;
    private String descripcion;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MascotaEntity> mascotas;
}

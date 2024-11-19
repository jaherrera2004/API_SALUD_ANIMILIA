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
@Table(name = "tipo_cita")
public class TipoCitaEntity {

    @Id
    private Integer id;

    private String tipoCita;
    private String descripcion;

    @OneToMany(mappedBy = "tipoCita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CitaEntity> citas;

}

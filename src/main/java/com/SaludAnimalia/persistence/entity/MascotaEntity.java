package com.SaludAnimalia.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mascotas")
public class MascotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String raza;
    private Integer edad;
    private String nombre;
    private char sexo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_animal", nullable = false)
    private AnimalEntity animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_duenio", nullable = false)
    private UsuarioEntity duenio;

    @OneToMany(mappedBy = "mascota", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CitaEntity> citas;

}

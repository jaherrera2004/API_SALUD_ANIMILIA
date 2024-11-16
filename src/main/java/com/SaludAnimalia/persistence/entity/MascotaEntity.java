package com.SaludAnimalia.persistence.entity;

import jakarta.persistence.*;

@Entity
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_duenio", nullable = false)
    private UsuarioEntity duenio;

}
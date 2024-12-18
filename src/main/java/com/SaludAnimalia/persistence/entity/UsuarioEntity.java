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
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String telefono;
    private String email;


    private String username;
    private String contrasenia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;

    @OneToMany(mappedBy = "duenio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MascotaEntity> mascotas;

    @OneToMany(mappedBy = "veterinario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TurnoEntity> turnos;
}

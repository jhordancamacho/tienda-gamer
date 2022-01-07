package com.storegamer.tiendagamer.modelo;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TECNOLOGIAS")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tecnologia")
    private Integer idTecnologia;

    @NotNull
    private String nombre;

    @NotNull
    private Character estado;
}

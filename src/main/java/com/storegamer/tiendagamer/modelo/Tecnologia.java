package com.storegamer.tiendagamer.modelo;


import javax.persistence.*;

@Entity
@Table(name = "TECNOLOGIAS")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tecnologia")
    private Integer idTecnologia;

    private String nombre;

    private Character estado;
}

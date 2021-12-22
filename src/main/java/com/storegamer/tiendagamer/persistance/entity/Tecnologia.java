package com.storegamer.tiendagamer.persistance.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TECNOLOGIAS")
public class Tecnologia {

    @Id
    @Column(name="id_tecnologia")
    private Integer idTecnologia;

    private String nombre;

    private Character estado;
}

package com.storegamer.tiendagamer.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="JUEGOS")
public class Juego {

    @Id
    @Column(name = "id_juego")
    private Integer idJuegos;

    private String nombre;

    private LocalDateTime ano;
    private String protagonistas;
    private String director;
    @Column(name="id_tecnologia")
    private Integer idTecnologia;
    private Integer precio;
}

package com.storegamer.tiendagamer.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="JUEGOS")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

package com.storegamer.tiendagamer.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name = "id_juego")
    private Integer idJuegos;

    private String nombre;
    private Integer ano;
    private String protagonistas;
    private String director;
    @Column(name="id_tecnologia")
    private Integer idTecnologia;
    private Integer precio;
}

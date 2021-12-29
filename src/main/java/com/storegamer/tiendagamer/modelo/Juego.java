package com.storegamer.tiendagamer.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="JUEGOS")
public class Juego {

    @Id
    @Column(name = "id_juego")
    private Integer idJuegos;

    @NotNull
    private String nombre;

    @NotNull
    private Integer ano;

    @NotNull
    private String protagonistas;

    @NotNull
    private String director;

    @Column(name="id_tecnologia")
    @NotNull
    private Integer idTecnologia;

    @NotNull
    private Integer precio;
}

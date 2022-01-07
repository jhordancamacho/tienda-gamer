package com.storegamer.tiendagamer.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "alquileres")
public class Alquiler {

    @EmbeddedId
    private AlquilerPK id;

    @Column(name="fecha_inicio") @NotNull
    private LocalDateTime fechaInicio;

    @Column(name="fecha_entrega") @NotNull
    private LocalDateTime fechaEntrega;
}

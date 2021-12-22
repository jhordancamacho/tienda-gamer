package com.storegamer.tiendagamer.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AlquilerPK implements Serializable {

    @Column(name = "id_juego")
    private Integer idJuego;

    @Column(name = "id_compra")
    private Integer idCompra;
}

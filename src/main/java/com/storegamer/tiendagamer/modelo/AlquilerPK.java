package com.storegamer.tiendagamer.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class AlquilerPK implements Serializable {

    @Column(name = "id_juego")
    private Integer idJuego;

    @Column(name = "id_compra")
    private Integer idCompra;
}

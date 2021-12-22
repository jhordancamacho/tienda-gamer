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
@Table(name = "COMPRAS")
public class Compra {

    @Id
    @Column(name="id_compra")
    private Integer idCompra;

    @Column(name="id_usuario")
    private Integer idUsuario;

    private LocalDateTime fecha;

    @Column(name="medio_pago")
    private Character medioPago;

    private Character estado;
}

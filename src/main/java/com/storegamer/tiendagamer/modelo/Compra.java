package com.storegamer.tiendagamer.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "COMPRAS")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    private Integer idCompra;

    @Column(name="id_usuario")
    private Integer idUsuario;

    private LocalDateTime fecha;

    @Column(name="medio_pago")
    private Character medioPago;

    private Character estado;
}

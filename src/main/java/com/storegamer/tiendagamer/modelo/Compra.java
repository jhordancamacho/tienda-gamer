package com.storegamer.tiendagamer.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @Column(name="id_compra")
    private int idCompra;

    @Column(name="id_usuario")
    private Integer idUsuario;

    private LocalDateTime fecha;

    @Column(name="medio_pago")
    private Character medioPago;

    @Column(name = "valor_total")
    private Integer valorTotal;

    private Character estado;
}

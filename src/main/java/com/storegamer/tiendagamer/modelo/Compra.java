package com.storegamer.tiendagamer.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @Column(name="id_compra")
    private int idCompra;

    @Column(name="id_usuario") @NotNull
    private Integer idUsuario;

    @NotNull
    private LocalDateTime fecha;

    @Column(name="medio_pago") @NotNull
    private Character medioPago;

    @Column(name = "numero_semanas") @NotNull
    private Integer numeroSemanas;

    @Column(name = "valor_total") @NotNull
    private Integer valorTotal;

    @NotNull
    private Character estado;
}

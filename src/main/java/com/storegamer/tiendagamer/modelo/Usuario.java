package com.storegamer.tiendagamer.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {


    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private BigInteger celular;
    @NotNull
    private String direccion;

    @Email @NotNull
    private String correo;

}

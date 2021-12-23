package com.storegamer.tiendagamer.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;

import javax.persistence.*;
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

    private String nombre;
    private String apellido;
    private BigInteger celular;
    private String direccion;

    @Email
    private String correo;

}

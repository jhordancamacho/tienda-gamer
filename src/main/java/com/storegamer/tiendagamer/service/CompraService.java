package com.storegamer.tiendagamer.service;

import com.storegamer.tiendagamer.commons.GenericService;
import com.storegamer.tiendagamer.modelo.Compra;

import java.time.LocalDateTime;

public interface CompraService extends GenericService<Compra,Integer> {

    //servicio para sumar semanas
    LocalDateTime sumarFecha(int numero_semanas);
}

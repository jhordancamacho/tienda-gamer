package com.storegamer.tiendagamer.dao;

import com.storegamer.tiendagamer.modelo.Juego;
import org.springframework.data.repository.CrudRepository;

public interface JuegoDao extends CrudRepository<Juego, Integer> {
}

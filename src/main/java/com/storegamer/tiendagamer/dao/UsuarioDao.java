package com.storegamer.tiendagamer.dao;

import com.storegamer.tiendagamer.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Integer> {
}

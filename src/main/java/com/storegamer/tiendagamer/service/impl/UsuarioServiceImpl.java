package com.storegamer.tiendagamer.service.impl;

import com.storegamer.tiendagamer.commons.GenericServiceImpl;
import com.storegamer.tiendagamer.dao.UsuarioDao;
import com.storegamer.tiendagamer.modelo.Usuario;
import com.storegamer.tiendagamer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario,Integer> implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public CrudRepository<Usuario,Integer> getDao(){return usuarioDao;}

}

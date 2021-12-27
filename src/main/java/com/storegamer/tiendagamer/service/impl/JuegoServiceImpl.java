package com.storegamer.tiendagamer.service.impl;

import com.storegamer.tiendagamer.commons.GenericServiceImpl;
import com.storegamer.tiendagamer.dao.JuegoDao;
import com.storegamer.tiendagamer.modelo.Juego;
import com.storegamer.tiendagamer.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class JuegoServiceImpl extends GenericServiceImpl<Juego,Integer> implements JuegoService {

    @Autowired
    private JuegoDao juegoDao;

    @Override
    public CrudRepository<Juego, Integer> getDao(){return juegoDao;}


}

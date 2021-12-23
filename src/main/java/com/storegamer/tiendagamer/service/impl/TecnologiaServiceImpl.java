package com.storegamer.tiendagamer.service.impl;

import com.storegamer.tiendagamer.commons.GenericServiceImpl;
import com.storegamer.tiendagamer.dao.TecnologiaDao;
import com.storegamer.tiendagamer.modelo.Tecnologia;
import com.storegamer.tiendagamer.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class TecnologiaServiceImpl extends GenericServiceImpl<Tecnologia,Integer> implements TecnologiaService {

    @Autowired
    private TecnologiaDao tecnologiaDao;

    @Override
    public CrudRepository<Tecnologia,Integer> getDao(){return tecnologiaDao;}


}

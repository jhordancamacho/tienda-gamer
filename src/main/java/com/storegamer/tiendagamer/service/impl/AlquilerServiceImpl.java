package com.storegamer.tiendagamer.service.impl;

import com.storegamer.tiendagamer.commons.GenericServiceImpl;
import com.storegamer.tiendagamer.dao.AlquilerDao;
import com.storegamer.tiendagamer.modelo.Alquiler;
import com.storegamer.tiendagamer.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AlquilerServiceImpl extends GenericServiceImpl<Alquiler, Integer> implements AlquilerService {

    @Autowired
    private AlquilerDao alquilerDao;

    @Override
    public CrudRepository<Alquiler, Integer> getDao(){
        return alquilerDao;
    }
    

}

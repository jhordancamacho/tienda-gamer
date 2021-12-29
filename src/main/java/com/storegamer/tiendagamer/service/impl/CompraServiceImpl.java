package com.storegamer.tiendagamer.service.impl;

import com.storegamer.tiendagamer.commons.GenericServiceImpl;
import com.storegamer.tiendagamer.dao.CompraDao;
import com.storegamer.tiendagamer.modelo.Compra;
import com.storegamer.tiendagamer.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl extends GenericServiceImpl<Compra, Integer> implements CompraService {


    @Autowired
    private CompraDao compraDao;

    @Override
    public CrudRepository<Compra, Integer> getDao(){
        return compraDao;
    }


}

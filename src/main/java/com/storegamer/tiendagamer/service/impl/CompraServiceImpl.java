package com.storegamer.tiendagamer.service.impl;

import com.storegamer.tiendagamer.commons.GenericServiceImpl;
import com.storegamer.tiendagamer.dao.CompraDao;
import com.storegamer.tiendagamer.modelo.Compra;
import com.storegamer.tiendagamer.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Service
public class CompraServiceImpl extends GenericServiceImpl<Compra, Integer> implements CompraService {


    @Autowired
    private CompraDao compraDao;

    @Override
    public CrudRepository<Compra, Integer> getDao(){
        return compraDao;
    }


    @Override
    public LocalDateTime sumarFecha(int numero_semanas){
        Calendar calendar = Calendar.getInstance();
        //fecha y hora actual
        LocalDateTime d=LocalDateTime.now();
        //enviamos la fecha y hora actual al calendario
        calendar.setTime(Date.from(d.atZone(ZoneId.systemDefault()).toInstant()));
        //sumamos las semanas dadas
        calendar.add(Calendar.WEEK_OF_YEAR, numero_semanas);
        //parseamos los datos a localdatetime
        Date dateTime=calendar.getTime();
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = format.format(dateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(str, formatter);
        System.out.println(localDateTime);
        return  localDateTime;
    }


}

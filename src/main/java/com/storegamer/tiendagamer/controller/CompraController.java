package com.storegamer.tiendagamer.controller;


import com.storegamer.tiendagamer.modelo.Compra;
import com.storegamer.tiendagamer.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraService compraService;

    @PostMapping("/agregar")
    public Map<String, Object> save(@RequestBody Compra compra) {
        if (compra.getIdUsuario() != null && compra.getEstado() != null && compra.getValorTotal() != null && compra.getMedioPago() != null) {
            LocalDateTime d = LocalDateTime.now();
            int idCompra = (int) (Math.random() * 9000 + 1000);
            compra.setIdCompra(idCompra);
            System.out.println(d.toString());
            compra.setFecha(d);
            compraService.save(compra);
            return compraService.msg(true, "Compra exitosa");
        }
        return compraService.msg(false, "Datos incorrectos");

    }


    @GetMapping("/today")
    public List<Compra> today() {
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()).toString();
        List<Compra> todas= compraService.getAll();
        List<Compra> returnList = new ArrayList<>();
        for (int i=0;i<todas.size();i++){
            String fechaBd=todas.get(i).getFecha().toString();
            fechaBd=fechaBd.substring(0,10);
            if(fechaActual.equals(fechaBd)){
                returnList.add(todas.get(i));
                }
        }
        return returnList;
    }
}

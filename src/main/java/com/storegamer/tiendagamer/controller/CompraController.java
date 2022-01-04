package com.storegamer.tiendagamer.controller;


import com.storegamer.tiendagamer.modelo.Alquiler;
import com.storegamer.tiendagamer.modelo.AlquilerPK;
import com.storegamer.tiendagamer.modelo.Compra;
import com.storegamer.tiendagamer.service.AlquilerService;
import com.storegamer.tiendagamer.service.CompraService;
import com.storegamer.tiendagamer.service.JuegoService;
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

    @Autowired
    JuegoService juegoService;

    @Autowired
    AlquilerService alquilerService;

    @PostMapping("/agregar/{idJuego}")
    public Map<String, Object> save(@RequestBody Compra compra,@PathVariable Integer idJuego) {
        if (compra.getIdUsuario() != null && compra.getEstado() != null && compra.getNumeroSemanas()!=null && compra.getMedioPago() != null) {
            LocalDateTime d = LocalDateTime.now();
            //String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()).toString();
            int idCompra = (int) (Math.random() * 90000 + 10000);
            int valorTotal= juegoService.get(idJuego).getPrecio() *compra.getNumeroSemanas();
            compra.setValorTotal(valorTotal);
            compra.setIdCompra(idCompra);
            compra.setFecha(d);
            compraService.save(compra);

            Alquiler alquiler=new Alquiler();
            AlquilerPK alquilerPK=new AlquilerPK();
            alquilerPK.setIdCompra(idCompra);
            alquilerPK.setIdJuego(idJuego);
            alquiler.setId(alquilerPK);
            alquiler.setFechaInicio(LocalDateTime.now());
            alquiler.setFechaEntrega(compraService.sumarFecha(compra.getNumeroSemanas()));
            alquilerService.save(alquiler);

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

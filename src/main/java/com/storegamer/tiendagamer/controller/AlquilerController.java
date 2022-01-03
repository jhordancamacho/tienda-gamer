package com.storegamer.tiendagamer.controller;

import com.storegamer.tiendagamer.modelo.Alquiler;
import com.storegamer.tiendagamer.modelo.Compra;
import com.storegamer.tiendagamer.modelo.Juego;
import com.storegamer.tiendagamer.modelo.Usuario;
import com.storegamer.tiendagamer.service.AlquilerService;
import com.storegamer.tiendagamer.service.CompraService;
import com.storegamer.tiendagamer.service.JuegoService;
import com.storegamer.tiendagamer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alquileres")
public class AlquilerController {

    @Autowired
    AlquilerService alquilerService;

    @Autowired
    JuegoService juegoService;

    @Autowired
    CompraService compraService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Alquiler> getAll() {
        return alquilerService.getAll();
    }

    @PostMapping("/insertar")
    public Map<String,Object> save(@RequestBody Alquiler alquiler){
    if(juegoService.get(alquiler.getId().getIdJuego())!=null && compraService.get(alquiler.getId().getIdCompra())!=null){
    alquilerService.save(alquiler);
        Juego juego=juegoService.get(alquiler.getId().getIdJuego());
        Compra compra=compraService.get(alquiler.getId().getIdCompra());
        Usuario usuario=usuarioService.get(compra.getIdUsuario());
        //Creando el objeto para la prueba de compra
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idCompra", compra.getIdCompra());
        respuesta.put("userName", usuario.getNombre()+usuario.getApellido());
        respuesta.put("idJuego", juego.getIdJuegos());
        respuesta.put("juegoName", juego.getNombre());
        respuesta.put("fechaInicio",alquiler.getFechaInicio());
        respuesta.put("fechaFin",alquiler.getFechaEntrega());
        //se envia el estado y la prueba de compra
    return alquilerService.msg(true,respuesta.toString());
    }
        return alquilerService.msg(false,"datos incorrectos");
    }

    @GetMapping("/alquiler/{id}")
    public List<Alquiler> getAll(@PathVariable Integer id) {
        List<Alquiler> returnList = new ArrayList<>();
        List<Compra> compraList=compraService.getAll();
        List<Alquiler> alquilerList=alquilerService.getAll();
        for (int i=0;i<alquilerList.size();i++){
            for (int e=0;e<compraList.size();e++){
                if(alquilerList.get(i).getId().getIdCompra().equals(compraList.get(e).getIdCompra())
                        && compraList.get(i).getIdUsuario().equals(id)){
                    returnList.add(alquilerList.get(i));
                }
            }
        }
        return returnList;
    }
}

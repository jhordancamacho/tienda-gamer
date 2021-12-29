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
        return alquilerService.msg(true,"si");
    }

    @GetMapping("/alquiler/{id}")
    public List<Alquiler> getAll(@PathVariable Integer id) {
        return alquilerService.getAllById(id);
    }
}

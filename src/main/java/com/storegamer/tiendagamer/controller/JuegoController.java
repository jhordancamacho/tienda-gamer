package com.storegamer.tiendagamer.controller;


import com.storegamer.tiendagamer.modelo.Juego;
import com.storegamer.tiendagamer.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    @Autowired
    JuegoService juegoService;

@PutMapping("actualizar/{id}")
    public Juego update(@PathVariable Integer id,@RequestBody Juego juegobody){
    Juego juego= juegoService.get(id);
    if(juego!=null){
        juegoService.delete(id);
        juegoService.save(juegobody);
    }
    return juegobody;
}
@PostMapping("/insertar")
    public ResponseEntity<Juego> save(@RequestBody Juego juego){
    if(juego.getNombre()!=null){
        Juego juegonew=juegoService.save(juego);
        return ResponseEntity.ok(juegonew);
    }
        return (ResponseEntity<Juego>) ResponseEntity.status(HttpStatus.NOT_FOUND);
}

@GetMapping("/{id}")
    public Juego find (@PathVariable Integer id){return juegoService.get(id);}
}

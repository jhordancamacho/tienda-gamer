package com.storegamer.tiendagamer.controller;


import com.storegamer.tiendagamer.modelo.Juego;
import com.storegamer.tiendagamer.modelo.Tecnologia;
import com.storegamer.tiendagamer.service.JuegoService;
import com.storegamer.tiendagamer.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    @Autowired
    JuegoService juegoService;

    @Autowired
    TecnologiaService tecnologiaService;

    @PutMapping("actualizar/{id}")
    public Juego update(@PathVariable final Integer id, @RequestBody final Juego juegobody) {
        final Juego juego = this.juegoService.get(id);
        if (juego != null) {
            this.juegoService.delete(id);
            this.juegoService.save(juegobody);
        }
        return juegobody;
    }

    @PostMapping("/insertar")
    public ResponseEntity<Juego> save(@RequestBody Juego juego) {
        Juego juegoId=juegoService.get(juego.getIdJuegos());
        Tecnologia tecnologiaId=tecnologiaService.get(juego.getIdTecnologia());
        if (juego != null) {

                if(tecnologiaId!=null && juegoId==null){
                    Juego juegoNew = this.juegoService.save(juego);
                    return ResponseEntity.ok(juegoNew);
                }
                else{
                    return new ResponseEntity(HttpStatus.CONFLICT);
                }
                }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public Juego find(@PathVariable Integer id) {
        return this.juegoService.get(id);
    }
}

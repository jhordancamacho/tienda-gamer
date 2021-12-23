package com.storegamer.tiendagamer.controller;

import com.storegamer.tiendagamer.modelo.Alquiler;
import com.storegamer.tiendagamer.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/alquileres")
public class AlquilerController {

    @Autowired
    AlquilerService alquilerService;

    @GetMapping
    public List<Alquiler> getAll() {
        return alquilerService.getAll();
    }
}

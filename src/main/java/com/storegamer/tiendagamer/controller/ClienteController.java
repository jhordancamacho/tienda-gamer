package com.storegamer.tiendagamer.controller;


import com.storegamer.tiendagamer.modelo.Usuario;
import com.storegamer.tiendagamer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        if(usuario.getNombre()!=null) {
            Usuario usuarioNew = usuarioService.save(usuario);
            return ResponseEntity.ok(usuarioNew);
        }
        return (ResponseEntity<Usuario>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
}

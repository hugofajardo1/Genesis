package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioCrearInput;
import com.ar.genesis.sistema.service.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UsuarioCrearController {
    @Inject
    IUsuarioCrearInput miUsuarioCrearInput;

    public UsuarioCrearController(IUsuarioCrearInput miUsuarioCrearInput) { this.miUsuarioCrearInput = miUsuarioCrearInput; }

    @PostMapping(value = "/usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO unUsuarioDTO){
        try{
            boolean resultado = this.miUsuarioCrearInput.crearUsuario(Usuario.instancia(unUsuarioDTO.getId(), unUsuarioDTO.getNombre(), unUsuarioDTO.getNombreUsuario(), unUsuarioDTO.getContrasenia()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UsuarioExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}

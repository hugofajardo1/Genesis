package com.ar.genesis.sistema.permiso.service.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoCrearInput;
import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoCrearController {
    @Inject
    IPermisoCrearInput miPermisoCrearInput;

    public PermisoCrearController(IPermisoCrearInput miPermisoCrearInput) {
        this.miPermisoCrearInput = miPermisoCrearInput;
    }

    @PostMapping(value = "/permiso")
    public ResponseEntity<?> crearPermiso(@RequestBody PermisoDTO unPermisoDTO){
        try{
            boolean resultado = this.miPermisoCrearInput.crearPermiso(Permiso.instancia(unPermisoDTO.getId(), unPermisoDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PermisoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
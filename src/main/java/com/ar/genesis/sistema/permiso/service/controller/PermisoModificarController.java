package com.ar.genesis.sistema.permiso.service.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoModificarInput;
import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoModificarController {
    @Inject
    IPermisoModificarInput miPermisoModificarInput;

    public PermisoModificarController(IPermisoModificarInput miPermisoModificarInput) { this.miPermisoModificarInput = miPermisoModificarInput; }

    @PutMapping(value = "/permiso")
    public ResponseEntity<?> modificarPermiso(@RequestBody PermisoDTO unPermisoDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miPermisoModificarInput.modificarPermiso(modelMapper.map(unPermisoDTO, Permiso.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PermisoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}

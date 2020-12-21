package com.ar.genesis.sistema.permiso.service.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoNoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoObtenerPorIdInput;
import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoObtenerPorIdController {
    @Inject
    IPermisoObtenerPorIdInput miPermisoObtenerPorIdInput;

    public PermisoObtenerPorIdController(IPermisoObtenerPorIdInput miPermisoObtenerPorIdInput) { this.miPermisoObtenerPorIdInput = miPermisoObtenerPorIdInput; }

    @GetMapping(value = "/permiso/id/{id}")
    public ResponseEntity<?> obtenerPermiso(@PathVariable Integer id){
        try{
            Permiso unPermiso = miPermisoObtenerPorIdInput.obtenerPermiso(id);
            PermisoDTO unPermisoDTO=null;
            if (unPermiso!=null){
                unPermisoDTO = new PermisoDTO(unPermiso.getId(), unPermiso.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unPermisoDTO);
        } catch (PermisoNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
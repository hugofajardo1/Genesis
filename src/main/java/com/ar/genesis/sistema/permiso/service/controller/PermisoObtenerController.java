package com.ar.genesis.sistema.permiso.service.controller;

import com.ar.genesis.sistema.permiso.core.input.IPermisoObtenerInput;
import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoObtenerController {
    @Inject
    IPermisoObtenerInput miPermisoObtenerInput;

    public PermisoObtenerController(IPermisoObtenerInput miPermisoObtenerInput) {
        this.miPermisoObtenerInput = miPermisoObtenerInput;
    }
    @GetMapping(value = "/permiso")
    public ResponseEntity<?> obtenerPermisos(){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<PermisoDTO> permisosDTO = new ArrayList<>();
            miPermisoObtenerInput.obtenerPermisos().forEach(unPermiso -> permisosDTO.add(modelMapper.map(unPermiso, PermisoDTO.class)));
            if (permisosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(permisosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

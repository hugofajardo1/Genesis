package com.ar.genesis.sistema.permisousuario.service.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioEliminarInput;
import com.ar.genesis.sistema.permisousuario.service.dto.PermisoUsuarioDTO;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoUsuarioEliminarController {
    @Inject
    IPermisoUsuarioEliminarInput miPermisoUsuarioEliminarInput;

    public PermisoUsuarioEliminarController(IPermisoUsuarioEliminarInput miPermisoUsuarioEliminarInput) { this.miPermisoUsuarioEliminarInput = miPermisoUsuarioEliminarInput; }

    @DeleteMapping(value = "/permisousuario")
    public ResponseEntity<?> eliminarPermisoUsuario(@RequestBody PermisoUsuarioDTO unPermisoUsuarioDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miPermisoUsuarioEliminarInput.eliminarPermisoUsuario(modelMapper.map(unPermisoUsuarioDTO, PermisoUsuario.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PermisoUsuarioNoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
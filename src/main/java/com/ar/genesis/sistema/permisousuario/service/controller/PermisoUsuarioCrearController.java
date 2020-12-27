package com.ar.genesis.sistema.permisousuario.service.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioCrearInput;
import com.ar.genesis.sistema.permisousuario.service.dto.PermisoUsuarioDTO;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoUsuarioCrearController {
    @Inject
    IPermisoUsuarioCrearInput miPermisoUsuarioCrearInput;

    public PermisoUsuarioCrearController(IPermisoUsuarioCrearInput miPermisoUsuarioCrearInput) {
        this.miPermisoUsuarioCrearInput = miPermisoUsuarioCrearInput;
    }

    @PostMapping(value = "/permisousuario")
    public ResponseEntity<?> crearPermisoUsuario(@RequestBody PermisoUsuarioDTO unPermisoUsuarioDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miPermisoUsuarioCrearInput.crearPermisoUsuario(modelMapper.map(unPermisoUsuarioDTO, PermisoUsuario.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PermisoUsuarioExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
package com.ar.genesis.sistema.permisousuario.service.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioModificarInput;
import com.ar.genesis.sistema.permisousuario.service.dto.PermisoUsuarioDTO;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoUsuarioModificarController {
    @Inject
    IPermisoUsuarioModificarInput miPermisoUsuarioModificarInput;

    public PermisoUsuarioModificarController(IPermisoUsuarioModificarInput miPermisoUsuarioModificarInput) { this.miPermisoUsuarioModificarInput = miPermisoUsuarioModificarInput; }

    @PutMapping(value = "/permisousuario")
    public ResponseEntity<?> modificarPermisoUsuario(@RequestBody PermisoUsuarioDTO unPermisoUsuarioDTO){
        try{
            boolean resultado = this.miPermisoUsuarioModificarInput.modificarPermisoUsuario(PermisoUsuario.instancia(unPermisoUsuarioDTO.getId(), Permiso.instancia(unPermisoUsuarioDTO.getPermiso().getId(), unPermisoUsuarioDTO.getPermiso().getNombre()), Usuario.instancia(unPermisoUsuarioDTO.getUsuario().getId(), unPermisoUsuarioDTO.getUsuario().getNombre(), unPermisoUsuarioDTO.getUsuario().getNombreUsuario(), unPermisoUsuarioDTO.getUsuario().getContrasenia(), Sucursal.instancia(unPermisoUsuarioDTO.getUsuario().getSucursal().getId(), unPermisoUsuarioDTO.getUsuario().getSucursal().getNombre()))));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PermisoUsuarioExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}

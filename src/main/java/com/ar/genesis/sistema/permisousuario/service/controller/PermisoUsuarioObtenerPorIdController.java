package com.ar.genesis.sistema.permisousuario.service.controller;

import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioObtenerPorIdInput;
import com.ar.genesis.sistema.permisousuario.service.dto.PermisoUsuarioDTO;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PermisoUsuarioObtenerPorIdController {
    @Inject
    IPermisoUsuarioObtenerPorIdInput miPermisoUsuarioObtenerPorIdInput;

    public PermisoUsuarioObtenerPorIdController(IPermisoUsuarioObtenerPorIdInput miPermisoUsuarioObtenerPorIdInput) { this.miPermisoUsuarioObtenerPorIdInput = miPermisoUsuarioObtenerPorIdInput; }

    @GetMapping(value = "/permisousuario/id/{id}")
    public ResponseEntity<?> obtenerPermisoUsuario(@PathVariable Integer id){
        try{
            PermisoUsuario unPermisoUsuario = miPermisoUsuarioObtenerPorIdInput.obtenerPermisoUsuario(id);
            PermisoUsuarioDTO unPermisoUsuarioDTO=null;
            if (unPermisoUsuario!=null){
                unPermisoUsuarioDTO = new PermisoUsuarioDTO(unPermisoUsuario.getId(), new PermisoDTO(unPermisoUsuario.getPermiso().getId(), unPermisoUsuario.getPermiso().getNombre()), new UsuarioDTO(unPermisoUsuario.getUsuario().getId(), unPermisoUsuario.getPermiso().getNombre(), unPermisoUsuario.getUsuario().getNombreUsuario(), unPermisoUsuario.getUsuario().getContrasenia(), new SucursalDTO(unPermisoUsuario.getUsuario().getSucursal().getId(), unPermisoUsuario.getUsuario().getSucursal().getNombre())));
            }
            return ResponseEntity.status(HttpStatus.OK).body(unPermisoUsuarioDTO);
        } catch (PermisoUsuarioNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
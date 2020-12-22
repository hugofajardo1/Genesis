package com.ar.genesis.sistema.permisousuario.service.controller;

import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioObtenerInput;
import com.ar.genesis.sistema.permisousuario.service.dto.PermisoUsuarioDTO;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
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
public class PermisoUsuarioObtenerController {
    @Inject
    IPermisoUsuarioObtenerInput miPermisoUsuarioObtenerInput;

    public PermisoUsuarioObtenerController(IPermisoUsuarioObtenerInput miPermisoUsuarioObtenerInput) {
        this.miPermisoUsuarioObtenerInput = miPermisoUsuarioObtenerInput;
    }
    @GetMapping(value = "/permisousuario")
    public ResponseEntity<?> obtenerPermisoUsuarios(){
        try{
            List<PermisoUsuarioDTO> permisousuariosDTO = new ArrayList<>();
            miPermisoUsuarioObtenerInput.obtenerPermisoUsuarios().forEach(unPermisoUsuario -> permisousuariosDTO.add(new PermisoUsuarioDTO(unPermisoUsuario.getId(), new PermisoDTO(unPermisoUsuario.getPermiso().getId(), unPermisoUsuario.getPermiso().getNombre()), new UsuarioDTO(unPermisoUsuario.getUsuario().getId(), unPermisoUsuario.getPermiso().getNombre(), unPermisoUsuario.getUsuario().getNombreUsuario(), unPermisoUsuario.getUsuario().getContrasenia(), new SucursalDTO(unPermisoUsuario.getUsuario().getSucursal().getId(), unPermisoUsuario.getUsuario().getSucursal().getNombre())))));
            if (permisousuariosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(permisousuariosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

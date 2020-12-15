package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IUsuarioObtenerInput;
import com.ar.genesis.sistema.service.dto.SucursalDTO;
import com.ar.genesis.sistema.service.dto.UsuarioDTO;
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
public class UsuarioObtenerController {
    @Inject
    IUsuarioObtenerInput miUsuarioObtenerInput;

    public UsuarioObtenerController(IUsuarioObtenerInput miUsuarioObtenerInput) { this.miUsuarioObtenerInput = miUsuarioObtenerInput; }

    @GetMapping(value = "/usuario")
    public ResponseEntity<?> obtenerUsuarios(){
        try{
            List<UsuarioDTO> usuariosDTO = new ArrayList<>();
            miUsuarioObtenerInput.obtenerUsuarios().forEach(unUsuario -> usuariosDTO.add(new UsuarioDTO(unUsuario.getId(), unUsuario.getNombre(), unUsuario.getNombreUsuario(), unUsuario.getContrasenia(), new SucursalDTO(unUsuario.getSucursal().getId(), unUsuario.getSucursal().getNombre()))));
            if (usuariosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(usuariosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

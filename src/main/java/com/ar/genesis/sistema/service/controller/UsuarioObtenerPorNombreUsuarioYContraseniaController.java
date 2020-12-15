package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioObtenerPorNombreUsuarioYContraseniaInput;
import com.ar.genesis.sistema.service.dto.SucursalDTO;
import com.ar.genesis.sistema.service.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UsuarioObtenerPorNombreUsuarioYContraseniaController {
    @Inject
    IUsuarioObtenerPorNombreUsuarioYContraseniaInput miUsuarioObtenerPorNombreUsuarioYContraseniaInput;

    public UsuarioObtenerPorNombreUsuarioYContraseniaController(IUsuarioObtenerPorNombreUsuarioYContraseniaInput miUsuarioObtenerPorNombreUsuarioYContraseniaInput) { this.miUsuarioObtenerPorNombreUsuarioYContraseniaInput = miUsuarioObtenerPorNombreUsuarioYContraseniaInput; }

    @GetMapping(value = "/usuario/nombreusuario/{nombreUsuario}/contrasenia/{contrasenia}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable String nombreUsuario, @PathVariable String contrasenia){
        try{
            Usuario unUsuario = miUsuarioObtenerPorNombreUsuarioYContraseniaInput.obtenerUsuario(nombreUsuario, contrasenia);
            UsuarioDTO unUsuarioDTO=null;
            if (unUsuario!=null){
                unUsuarioDTO = new UsuarioDTO(unUsuario.getId(), unUsuario.getNombre(), unUsuario.getNombreUsuario(), unUsuario.getContrasenia(), new SucursalDTO(unUsuario.getSucursal().getId(), unUsuario.getSucursal().getNombre()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(unUsuarioDTO);
        } catch (UsuarioNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
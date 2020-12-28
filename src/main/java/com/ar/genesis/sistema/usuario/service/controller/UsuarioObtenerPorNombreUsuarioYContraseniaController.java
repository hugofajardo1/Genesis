package com.ar.genesis.sistema.usuario.service.controller;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.usuario.core.input.IUsuarioObtenerPorNombreUsuarioYContraseniaInput;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
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
                ModelMapper modelMapper = new ModelMapper();
                unUsuarioDTO = modelMapper.map(unUsuario, UsuarioDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(unUsuarioDTO);
        } catch (UsuarioNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
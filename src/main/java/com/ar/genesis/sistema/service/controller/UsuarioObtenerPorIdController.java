package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioObtenerPorIdInput;
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
public class UsuarioObtenerPorIdController {
    @Inject
    IUsuarioObtenerPorIdInput miUsuarioObtenerPorIdInput;

    public UsuarioObtenerPorIdController(IUsuarioObtenerPorIdInput miUsuarioObtenerPorIdInput) { this.miUsuarioObtenerPorIdInput = miUsuarioObtenerPorIdInput; }

    @GetMapping(value = "/usuario/id/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Integer id){
        try{
            Usuario unUsuario = miUsuarioObtenerPorIdInput.obtenerUsuario(id);
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
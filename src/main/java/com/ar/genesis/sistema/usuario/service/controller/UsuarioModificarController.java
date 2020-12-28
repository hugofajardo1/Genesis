package com.ar.genesis.sistema.usuario.service.controller;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.usuario.core.input.IUsuarioModificarInput;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UsuarioModificarController {
    @Inject
    IUsuarioModificarInput miUsuarioModificarInput;

    public UsuarioModificarController(IUsuarioModificarInput miUsuarioModificarInput) { this.miUsuarioModificarInput = miUsuarioModificarInput; }

    @PutMapping(value = "/usuario")
    public ResponseEntity<?> modificarUsuario(@RequestBody UsuarioDTO unUsuarioDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miUsuarioModificarInput.modificarUsuario(modelMapper.map(unUsuarioDTO, Usuario.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UsuarioExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}

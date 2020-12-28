package com.ar.genesis.sistema.usuario.service.controller;

import com.ar.genesis.sistema.usuario.core.input.IUsuarioObtenerInput;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
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
            ModelMapper modelMapper = new ModelMapper();
            List<UsuarioDTO> usuariosDTO = new ArrayList<>();
            miUsuarioObtenerInput.obtenerUsuarios().forEach(unUsuario -> usuariosDTO.add(modelMapper.map(unUsuario, UsuarioDTO.class)));
            if (usuariosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(usuariosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

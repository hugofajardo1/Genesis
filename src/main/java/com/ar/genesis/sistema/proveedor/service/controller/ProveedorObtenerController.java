package com.ar.genesis.sistema.proveedor.service.controller;

import com.ar.genesis.sistema.proveedor.core.input.IProveedorObtenerInput;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
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
public class ProveedorObtenerController {
    @Inject
    IProveedorObtenerInput miProveedorObtenerInput;

    public ProveedorObtenerController(IProveedorObtenerInput miProveedorObtenerInput) { this.miProveedorObtenerInput = miProveedorObtenerInput; }

    @GetMapping(value = "/proveedor")
    public ResponseEntity<?> obtenerProveedores(){
        try{
            List<ProveedorDTO> ProveedoresDTO = new ArrayList<>();
            miProveedorObtenerInput.obtenerProveedores().forEach(unProveedor -> ProveedoresDTO.add(new ProveedorDTO(unProveedor.getId(), unProveedor.getNombre())));
            if (ProveedoresDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(ProveedoresDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

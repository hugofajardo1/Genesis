package com.ar.genesis.sistema.proveedor.service.controller;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorNoExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorObtenerPorIdInput;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProveedorObtenerPorIdController {
    @Inject
    IProveedorObtenerPorIdInput miProveedorObtenerPorIdInput;

    public ProveedorObtenerPorIdController(IProveedorObtenerPorIdInput miProveedorObtenerPorIdInput) { this.miProveedorObtenerPorIdInput = miProveedorObtenerPorIdInput; }

    @GetMapping(value = "/proveedor/id/{id}")
    public ResponseEntity<?> obtenerProveedor(@PathVariable Integer id){
        try{
            Proveedor unProveedor = miProveedorObtenerPorIdInput.obtenerProveedor(id);
            ProveedorDTO unProveedorDTO=null;
            if (unProveedor!=null){
                unProveedorDTO = new ProveedorDTO(unProveedor.getId(), unProveedor.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unProveedorDTO);
        } catch (ProveedorNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
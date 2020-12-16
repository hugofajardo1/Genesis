package com.ar.genesis.sistema.vendedor.service.controller;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorNoExisteException;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorObtenerPorIdInput;
import com.ar.genesis.sistema.vendedor.service.dto.VendedorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class VendedorObtenerPorIdController {
    @Inject
    IVendedorObtenerPorIdInput miVendedorObtenerPorIdInput;

    public VendedorObtenerPorIdController(IVendedorObtenerPorIdInput miVendedorObtenerPorIdInput) { this.miVendedorObtenerPorIdInput = miVendedorObtenerPorIdInput; }

    @GetMapping(value = "/vendedor/id/{id}")
    public ResponseEntity<?> obtenerVendedor(@PathVariable Integer id){
        try{
            Vendedor unVendedor = miVendedorObtenerPorIdInput.obtenerVendedor(id);
            VendedorDTO unVendedorDTO=null;
            if (unVendedor!=null){
                unVendedorDTO = new VendedorDTO(unVendedor.getId(), unVendedor.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unVendedorDTO);
        } catch (VendedorNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
package com.ar.genesis.sistema.vendedor.service.controller;

import com.ar.genesis.sistema.vendedor.core.input.IVendedorObtenerInput;
import com.ar.genesis.sistema.vendedor.service.dto.VendedorDTO;
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
public class VendedorObtenerController {
    @Inject
    IVendedorObtenerInput miVendedorObtenerInput;

    public VendedorObtenerController(IVendedorObtenerInput miVendedorObtenerInput) { this.miVendedorObtenerInput = miVendedorObtenerInput; }

    @GetMapping(value = "/vendedor")
    public ResponseEntity<?> obtenerVendedores(){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<VendedorDTO> vendedoresDTO = new ArrayList<>();
            miVendedorObtenerInput.obtenerVendedores().forEach(unVendedor -> vendedoresDTO.add(modelMapper.map(unVendedor, VendedorDTO.class)));
            if (vendedoresDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(vendedoresDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

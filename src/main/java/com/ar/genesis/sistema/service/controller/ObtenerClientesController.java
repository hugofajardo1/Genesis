package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerClientesInput;
import com.ar.genesis.sistema.service.dto.ClienteDTO;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ObtenerClientesController {
    @Inject
    IObtenerClientesInput iObtenerClientesInput;

    public ObtenerClientesController(IObtenerClientesInput iObtenerClientesInput) {
        this.iObtenerClientesInput = iObtenerClientesInput;
    }
    @GetMapping(value = "/clientes")
    public ResponseEntity<?> obtenerClientes(){
        try{
            List<ClienteDTO> clientesDTO = new ArrayList<>();
            iObtenerClientesInput.obtenerClientes().forEach(cliente -> clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getDomicilio(), cliente.getTelefono(), new TipoIvaDTO(1, "Responsable Inscripto"))));
            if (clientesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(clientesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

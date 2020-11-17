package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.input.IModificarClienteInput;
import com.ar.genesis.sistema.service.dto.ClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ModificarClienteController {

    @Inject
    IModificarClienteInput iModificarClienteInput;

    public ModificarClienteController(IModificarClienteInput iModificarClienteInput) {
        this.iModificarClienteInput = iModificarClienteInput;
    }
    @PutMapping(value = "/cliente")
    public ResponseEntity<?> modificarCliente(@RequestBody ClienteDTO clienteDTO){
        try{
            boolean resultado = this.iModificarClienteInput.modificarCliente(Cliente.instancia(clienteDTO.getId(), clienteDTO.getNombre(), clienteDTO.getDomicilio(), clienteDTO.getTelefono()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ClienteExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}

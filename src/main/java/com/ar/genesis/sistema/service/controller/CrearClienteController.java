package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearClienteInput;
import com.ar.genesis.sistema.service.dto.ClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/")
@RestController
public class CrearClienteController {

    ICrearClienteInput iCrearClienteInput;

    public CrearClienteController(ICrearClienteInput iCrearClienteInput) {
        this.iCrearClienteInput = iCrearClienteInput;
    }

    @RequestMapping(value = "cliente", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearCliente(@RequestBody ClienteDTO clienteDTO){
        try{
            boolean resultado = this.iCrearClienteInput.crearCliente(Cliente.instancia(clienteDTO.getId(), clienteDTO.getNombre(), clienteDTO.getDomicilio(), clienteDTO.getTelefono()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ClienteExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
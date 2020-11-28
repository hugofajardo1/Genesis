package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.input.ICrearLocalidadInput;
import com.ar.genesis.sistema.service.controller.CrearLocalidadController;
import com.ar.genesis.sistema.service.dto.LocalidadDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrearLocalidadControllerTest {
    @Mock
    ICrearLocalidadInput crearLocalidadInput;

    @Test
    public  void crearLocalidad_LocalidadNoExiste_Devuelve200() throws LocalidadExisteException {
        LocalidadDTO localidadDTO = new LocalidadDTO(1, "Localidad 1");
        when(crearLocalidadInput.crearLocalidad(any(Localidad.class))).thenReturn(true);

        CrearLocalidadController crearLocalidadController = new CrearLocalidadController(crearLocalidadInput);
        ResponseEntity<?> responseEntity = crearLocalidadController.crearLocalidad(localidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearLocalidad_LocalidadExiste_Devuelve412() throws LocalidadExisteException {
        LocalidadDTO localidadDTO = new LocalidadDTO(1, "Localidad 1");
        when(crearLocalidadInput.crearLocalidad(any(Localidad.class))).thenThrow(LocalidadExisteException.class);

        CrearLocalidadController crearLocalidadController = new CrearLocalidadController(crearLocalidadInput);
        ResponseEntity<?> responseEntity = crearLocalidadController.crearLocalidad(localidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

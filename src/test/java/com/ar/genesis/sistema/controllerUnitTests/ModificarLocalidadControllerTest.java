package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.input.IModificarLocalidadInput;
import com.ar.genesis.sistema.service.controller.ModificarLocalidadController;
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
public class ModificarLocalidadControllerTest {
    @Mock
    IModificarLocalidadInput modificarLocalidadInput;

    @Test
    public  void modificarLocalidad_LocalidadNoExiste_Devuelve200() throws LocalidadExisteException {
        LocalidadDTO LocalidadDTO = new LocalidadDTO(1, "Localidad 1");
        when(modificarLocalidadInput.modificarLocalidad(any(Localidad.class))).thenReturn(true);

        ModificarLocalidadController modificarLocalidadController = new ModificarLocalidadController(modificarLocalidadInput);
        ResponseEntity<?> responseEntity = modificarLocalidadController.modificarLocalidad(LocalidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarLocalidad_LocalidadExiste_Devuelve412() throws LocalidadExisteException {
        LocalidadDTO LocalidadDTO = new LocalidadDTO(1, "Localidad 2");
        when(modificarLocalidadInput.modificarLocalidad(any(Localidad.class))).thenThrow(LocalidadExisteException.class);

        ModificarLocalidadController modificarLocalidadController = new ModificarLocalidadController(modificarLocalidadInput);
        ResponseEntity<?> responseEntity = modificarLocalidadController.modificarLocalidad(LocalidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

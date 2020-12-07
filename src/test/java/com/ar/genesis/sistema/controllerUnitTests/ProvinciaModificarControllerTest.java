package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.IProvinciaModificarInput;
import com.ar.genesis.sistema.service.controller.ProvinciaModificarController;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProvinciaModificarControllerTest {
    @Mock
    IProvinciaModificarInput miProvinciaModificarInput;

    @Test
    public  void modificarProvincia_ProvinciaNoExiste_Devuelve200() throws ProvinciaExisteException {
        ProvinciaDTO unProvinciaDTO = new ProvinciaDTO(1, "Provincia 1");
        when(miProvinciaModificarInput.modificarProvincia(any(Provincia.class))).thenReturn(true);

        ProvinciaModificarController provinciaModificarController = new ProvinciaModificarController(miProvinciaModificarInput);
        ResponseEntity<?> responseEntity = provinciaModificarController.modificarProvincia(unProvinciaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarProvincia_ProvinciaExiste_Devuelve412() throws ProvinciaExisteException {
        ProvinciaDTO unProvinciaDTO = new ProvinciaDTO(1, "Provincia 2");
        when(miProvinciaModificarInput.modificarProvincia(any(Provincia.class))).thenThrow(ProvinciaExisteException.class);

        ProvinciaModificarController provinciaModificarController = new ProvinciaModificarController(miProvinciaModificarInput);
        ResponseEntity<?> responseEntity = provinciaModificarController.modificarProvincia(unProvinciaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

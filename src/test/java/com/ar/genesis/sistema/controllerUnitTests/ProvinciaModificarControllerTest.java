package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.IModificarProvinciaInput;
import com.ar.genesis.sistema.service.controller.ModificarProvinciaController;
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
    IModificarProvinciaInput miModificarProvinciaInput;

    @Test
    public  void modificarProvincia_ProvinciaNoExiste_Devuelve200() throws ProvinciaExisteException {
        ProvinciaDTO unProvinciaDTO = new ProvinciaDTO(1, "Provincia 1");
        when(miModificarProvinciaInput.modificarProvincia(any(Provincia.class))).thenReturn(true);

        ModificarProvinciaController modificarProvinciaController = new ModificarProvinciaController(miModificarProvinciaInput);
        ResponseEntity<?> responseEntity = modificarProvinciaController.modificarProvincia(unProvinciaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarProvincia_ProvinciaExiste_Devuelve412() throws ProvinciaExisteException {
        ProvinciaDTO unProvinciaDTO = new ProvinciaDTO(1, "Provincia 2");
        when(miModificarProvinciaInput.modificarProvincia(any(Provincia.class))).thenThrow(ProvinciaExisteException.class);

        ModificarProvinciaController modificarProvinciaController = new ModificarProvinciaController(miModificarProvinciaInput);
        ResponseEntity<?> responseEntity = modificarProvinciaController.modificarProvincia(unProvinciaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

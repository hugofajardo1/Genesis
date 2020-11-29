package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoUnidadInput;
import com.ar.genesis.sistema.service.controller.TipoUnidadModificarController;
import com.ar.genesis.sistema.service.dto.TipoUnidadDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoUnidadModificarControllerTest {
    @Mock
    IModificarTipoUnidadInput miModificarTipoUnidadInput;

    @Test
    public  void modificarTipoUnidad_TipoUnidadNoExiste_Devuelve200() throws TipoUnidadExisteException {
        TipoUnidadDTO unTipoUnidadDTO = new TipoUnidadDTO(1, "Responsable Inscripto");
        when(miModificarTipoUnidadInput.modificarTipoUnidad(any(TipoUnidad.class))).thenReturn(true);

        TipoUnidadModificarController tipoUnidadModificarController = new TipoUnidadModificarController(miModificarTipoUnidadInput);
        ResponseEntity<?> responseEntity = tipoUnidadModificarController.modificarTipoUnidad(unTipoUnidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarTipoUnidad_TipoUnidadExiste_Devuelve412() throws TipoUnidadExisteException {
        TipoUnidadDTO unTipoUnidadDTO = new TipoUnidadDTO(1, "Responsable Inscripto");
        when(miModificarTipoUnidadInput.modificarTipoUnidad(any(TipoUnidad.class))).thenThrow(TipoUnidadExisteException.class);

        TipoUnidadModificarController tipoUnidadModificarController = new TipoUnidadModificarController(miModificarTipoUnidadInput);
        ResponseEntity<?> responseEntity = tipoUnidadModificarController.modificarTipoUnidad(unTipoUnidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoUnidadInput;
import com.ar.genesis.sistema.service.controller.ModificarTipoUnidadController;
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
public class ModificarTipoUnidadControllerTest {
    @Mock
    IModificarTipoUnidadInput modificarTipoUnidadInput;

    @Test
    public  void crearTipoUnidad_TipoUnidadNoExiste_Devuelve200() throws TipoUnidadExisteException {
        TipoUnidadDTO tipoUnidadDTO = new TipoUnidadDTO(1, "Responsable Inscripto");
        when(modificarTipoUnidadInput.modificarTipoUnidad(any(TipoUnidad.class))).thenReturn(true);

        ModificarTipoUnidadController modificarTipoUnidadController = new ModificarTipoUnidadController(modificarTipoUnidadInput);
        ResponseEntity<?> responseEntity = modificarTipoUnidadController.modificarTipoUnidad(tipoUnidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoUnidad_TipoUnidadExiste_Devuelve412() throws TipoUnidadExisteException {
        TipoUnidadDTO tipoUnidadDTO = new TipoUnidadDTO(1, "Responsable Inscripto");
        when(modificarTipoUnidadInput.modificarTipoUnidad(any(TipoUnidad.class))).thenThrow(TipoUnidadExisteException.class);

        ModificarTipoUnidadController modificarTipoUnidadController = new ModificarTipoUnidadController(modificarTipoUnidadInput);
        ResponseEntity<?> responseEntity = modificarTipoUnidadController.modificarTipoUnidad(tipoUnidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}

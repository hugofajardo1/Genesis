package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearSubRubroInput;
import com.ar.genesis.sistema.service.controller.CrearSubRubroController;
import com.ar.genesis.sistema.service.dto.SubRubroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrearSubRubroControllerUT {
    @Mock
    ICrearSubRubroInput crearTipoClienteInput;

    @Test
    public  void crearTipoCliente_TipoClienteNoExiste_Devuelve200() throws SubRubroExisteException {
        SubRubroDTO subRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(crearTipoClienteInput.crearSubRubro(any(SubRubro.class))).thenReturn(true);

        CrearSubRubroController crearSubRubroController = new CrearSubRubroController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearSubRubroController.crearSubRubro(subRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoCliente_TipoClienteExiste_Devuelve412() throws SubRubroExisteException {
        SubRubroDTO subRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(crearTipoClienteInput.crearSubRubro(any(SubRubro.class))).thenThrow(SubRubroExisteException.class);

        CrearSubRubroController crearSubRubroController = new CrearSubRubroController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearSubRubroController.crearSubRubro(subRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}

package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.ISubRubroModificarInput;
import com.ar.genesis.sistema.service.controller.SubRubroModificarController;
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
public class SubRubroModificarControllerTest {
    @Mock
    ISubRubroModificarInput miSubRubroModificarInput;

    @Test
    public  void modificarSubRubro_SubRubroNoExiste_Devuelve200() throws SubRubroExisteException {
        SubRubroDTO unSubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(miSubRubroModificarInput.modificarSubRubro(any(SubRubro.class))).thenReturn(true);

        SubRubroModificarController subRubroModificarController = new SubRubroModificarController(miSubRubroModificarInput);
        ResponseEntity<?> responseEntity = subRubroModificarController.modificarSubRubro(unSubRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarSubRubro_SubRubroExiste_Devuelve412() throws SubRubroExisteException {
        SubRubroDTO unSubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(miSubRubroModificarInput.modificarSubRubro(any(SubRubro.class))).thenThrow(SubRubroExisteException.class);

        SubRubroModificarController subRubroModificarController = new SubRubroModificarController(miSubRubroModificarInput);
        ResponseEntity<?> responseEntity = subRubroModificarController.modificarSubRubro(unSubRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

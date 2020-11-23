package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.IModificarSubRubroInput;
import com.ar.genesis.sistema.service.controller.ModificarSubRubroController;
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
public class ModificarSubRubroControllerTest {
    @Mock
    IModificarSubRubroInput modificarSubRubroInput;

    @Test
    public  void crearSubRubro_SubRubroNoExiste_Devuelve200() throws SubRubroExisteException {
        SubRubroDTO SubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(modificarSubRubroInput.modificarSubRubro(any(SubRubro.class))).thenReturn(true);

        ModificarSubRubroController modificarSubRubroController = new ModificarSubRubroController(modificarSubRubroInput);
        ResponseEntity<?> responseEntity = modificarSubRubroController.modificarSubRubro(SubRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearSubRubro_SubRubroExiste_Devuelve412() throws SubRubroExisteException {
        SubRubroDTO SubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(modificarSubRubroInput.modificarSubRubro(any(SubRubro.class))).thenThrow(SubRubroExisteException.class);

        ModificarSubRubroController modificarSubRubroController = new ModificarSubRubroController(modificarSubRubroInput);
        ResponseEntity<?> responseEntity = modificarSubRubroController.modificarSubRubro(SubRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}

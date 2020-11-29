package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.input.IModificarRubroInput;
import com.ar.genesis.sistema.service.controller.ModificarRubroController;
import com.ar.genesis.sistema.service.dto.RubroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RubroModificarControllerTest {
    @Mock
    IModificarRubroInput miModificarRubroInput;

    @Test
    public  void modificarRubro_RubroNoExiste_Devuelve200() throws RubroExisteException {
        RubroDTO unRubroDTO = new RubroDTO(1, "Rubro 1");
        when(miModificarRubroInput.modificarRubro(any(Rubro.class))).thenReturn(true);

        ModificarRubroController modificarRubroController = new ModificarRubroController(miModificarRubroInput);
        ResponseEntity<?> responseEntity = modificarRubroController.modificarRubro(unRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarRubro_RubroExiste_Devuelve412() throws RubroExisteException {
        RubroDTO unRubroDTO = new RubroDTO(1, "Rubro 2");
        when(miModificarRubroInput.modificarRubro(any(Rubro.class))).thenThrow(RubroExisteException.class);

        ModificarRubroController modificarRubroController = new ModificarRubroController(miModificarRubroInput);
        ResponseEntity<?> responseEntity = modificarRubroController.modificarRubro(unRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

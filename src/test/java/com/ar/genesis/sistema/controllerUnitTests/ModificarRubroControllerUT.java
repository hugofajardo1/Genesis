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
public class ModificarRubroControllerUT {
    @Mock
    IModificarRubroInput modificarRubroInput;

    @Test
    public  void crearRubro_RubroNoExiste_Devuelve200() throws RubroExisteException {
        RubroDTO RubroDTO = new RubroDTO(1, "Rubro");
        when(modificarRubroInput.modificarRubro(any(Rubro.class))).thenReturn(true);

        ModificarRubroController modificarRubroController = new ModificarRubroController(modificarRubroInput);
        ResponseEntity<?> responseEntity = modificarRubroController.modificarRubro(RubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearRubro_RubroExiste_Devuelve412() throws RubroExisteException {
        RubroDTO RubroDTO = new RubroDTO(1, "Rubro");
        when(modificarRubroInput.modificarRubro(any(Rubro.class))).thenThrow(RubroExisteException.class);

        ModificarRubroController modificarRubroController = new ModificarRubroController(modificarRubroInput);
        ResponseEntity<?> responseEntity = modificarRubroController.modificarRubro(RubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}

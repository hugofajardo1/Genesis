package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearRubroInput;
import com.ar.genesis.sistema.service.controller.CrearRubroController;
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
public class CrearRubroControllerUT {
    @Mock
    ICrearRubroInput crearTipoClienteInput;

    @Test
    public  void crearTipoCliente_TipoClienteNoExiste_Devuelve200() throws RubroExisteException {
        RubroDTO RubroDTO = new RubroDTO(1, "Rubro");
        when(crearTipoClienteInput.crearRubro(any(Rubro.class))).thenReturn(true);

        CrearRubroController crearRubroController = new CrearRubroController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearRubroController.crearRubro(RubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoCliente_TipoClienteExiste_Devuelve412() throws RubroExisteException {
        RubroDTO RubroDTO = new RubroDTO(1, "Rubro");
        when(crearTipoClienteInput.crearRubro(any(Rubro.class))).thenThrow(RubroExisteException.class);

        CrearRubroController crearRubroController = new CrearRubroController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearRubroController.crearRubro(RubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}

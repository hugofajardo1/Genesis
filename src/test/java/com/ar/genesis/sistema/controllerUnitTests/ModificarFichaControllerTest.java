package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.input.IModificarFichaInput;
import com.ar.genesis.sistema.service.controller.ModificarFichaController;
import com.ar.genesis.sistema.service.dto.FichaDTO;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ModificarFichaControllerTest {
    @Mock
    IModificarFichaInput iModificarFichaInput;

    @Test
    public  void modificarFicha_FichaNoExiste_Devuelve200() throws FichaExisteException {
        FichaDTO fichaDTO = new FichaDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", "3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336");
        when(iModificarFichaInput.modificarFicha(any(Ficha.class))).thenReturn(true);

        ModificarFichaController modificarFichaController = new ModificarFichaController(iModificarFichaInput);
        ResponseEntity<?> responseEntity = modificarFichaController.modificarFicha(fichaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarFicha_FichaExiste_Devuelve412() throws FichaExisteException {
        FichaDTO fichaDTO = new FichaDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", "3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336");
        when(iModificarFichaInput.modificarFicha(any(Ficha.class))).thenThrow(FichaExisteException.class);

        ModificarFichaController modificarFichaController = new ModificarFichaController(iModificarFichaInput);
        ResponseEntity<?> responseEntity = modificarFichaController.modificarFicha(fichaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}

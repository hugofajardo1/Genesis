package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.input.IFichaModificarInput;
import com.ar.genesis.sistema.service.controller.FichaModificarController;
import com.ar.genesis.sistema.service.dto.FichaDTO;
import com.ar.genesis.sistema.service.dto.LocalidadDTO;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
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
public class FichaModificarControllerTest {
    @Mock
    IFichaModificarInput miFichaModificarInput;

    @Test
    public  void modificarFicha_FichaNoExiste_Devuelve200() throws FichaExisteException {
        FichaDTO unaFichaDTO = new FichaDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", new LocalidadDTO(1, "Chilecito"), new ProvinciaDTO(1, "La Rioja"),"3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336", "007-4343-0", "hugofajardo1@gmail.com");
        when(miFichaModificarInput.modificarFicha(any(Ficha.class))).thenReturn(true);

        FichaModificarController fichaModificarController = new FichaModificarController(miFichaModificarInput);
        ResponseEntity<?> responseEntity = fichaModificarController.modificarFicha(unaFichaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarFicha_FichaExiste_Devuelve412() throws FichaExisteException {
        FichaDTO unaFichaDTO = new FichaDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", new LocalidadDTO(1, "Chilecito"), new ProvinciaDTO(1, "La Rioja"),"3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336", "007-4343-0", "hugofajardo1@gmail.com");
        when(miFichaModificarInput.modificarFicha(any(Ficha.class))).thenThrow(FichaExisteException.class);

        FichaModificarController fichaModificarController = new FichaModificarController(miFichaModificarInput);
        ResponseEntity<?> responseEntity = fichaModificarController.modificarFicha(unaFichaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
